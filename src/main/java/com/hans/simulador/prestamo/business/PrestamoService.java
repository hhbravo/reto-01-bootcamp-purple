package com.hans.simulador.prestamo.business;

import com.hans.simulador.prestamo.entity.PrestamoRequest;
import com.hans.simulador.prestamo.entity.PrestamoResponse;
import com.hans.simulador.prestamo.model.Card;
import com.hans.simulador.prestamo.model.User;
import com.hans.simulador.prestamo.model.UserCard;
import com.hans.simulador.prestamo.repository.CardRepository;
import com.hans.simulador.prestamo.repository.UserCardRepository;
import com.hans.simulador.prestamo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PrestamoService {

    Logger logger = LoggerFactory.getLogger(PrestamoService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserCardRepository userCardRepository;

    public PrestamoResponse monthlyFee(PrestamoRequest prestamoRequest) throws Exception {

        validateForm(prestamoRequest);

        var tem = calculateTem(Double.parseDouble(prestamoRequest.getTea().replace("%", "")));

        var frc = calculateFrc(round(tem, 3), prestamoRequest.getCuota());

        //cuota
        var cuot = round(calculateCuot(frc, prestamoRequest.getMonto(), 0.005), 3);

        logger.info("cuota: {}", cuot);

        PrestamoResponse prestamoResponse = new PrestamoResponse();
        prestamoResponse.setCuota(cuot);
        prestamoResponse.setMoneda(prestamoRequest.getMoneda());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        prestamoResponse.setPrimeraCuota(
                dtf.format(LocalDate
                        .now()
                        .plusMonths(1)
                        .withDayOfMonth(
                                Integer.parseInt(
                                        prestamoRequest.getDiaPago()))));
        prestamoResponse.setEstado("Exitoso");
        return prestamoResponse;
    }

    private void validateForm(PrestamoRequest prestamoRequest) {
        User user = getUser(prestamoRequest.getDni());

        if (user == null) {
            throw  new EntityNotFoundException("No se encuentra el cliente solicitado");
        }
        Card card = getCard(prestamoRequest.getTarjeta());
        if (card == null) {
            throw  new EntityNotFoundException("No se encontro la tarjeta solicitada");
        }

        UserCard  userCard = getUserCard(user.getId(), card.getId());
        if (userCard == null) {
            throw  new EntityNotFoundException(String.
                    format("El cliente no cuenta con la tarjeta %s", card.getValue()));
        }

    }

    private Card getCard(String tarjeta) {
        return cardRepository.findCardByValue(tarjeta).orElse(null);
    }

    private User getUser(String dni) {
        return userRepository.findByDocument(dni).orElse(null);
    }

    private UserCard getUserCard(Integer userId, Integer cardId) {
        return userCardRepository.findByUsuarioIdAndTarjetaId(userId, cardId).orElse(null);
    }


    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    private double calculateTem(Double tea) {
        return Math.pow(1 + tea, 0.083333) - 1;
    }

    private double calculateFrc(Double tem, Integer period) {
        var dividendo = tem * Math.pow(1 + tem, period);
        var divisor = Math.pow(1 + tem, period) - 1;
        return dividendo / divisor;
    }

    private double calculateCuot(Double frc, Double mont, Double itf) {
        return (frc * mont) + itf;
    }
}
