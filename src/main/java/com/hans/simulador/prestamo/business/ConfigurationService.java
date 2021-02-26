package com.hans.simulador.prestamo.business;

import com.hans.simulador.prestamo.model.Card;
import com.hans.simulador.prestamo.model.Parametro;
import com.hans.simulador.prestamo.model.Tea;
import com.hans.simulador.prestamo.entity.ConfiguracionResponse;
import com.hans.simulador.prestamo.repository.ParametroRepository;
import com.hans.simulador.prestamo.repository.CardRepository;
import com.hans.simulador.prestamo.repository.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ConfigurationService {

    @Autowired
    private ParametroRepository parametroRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TeaRepository teaRepository;

    public ConfiguracionResponse config() {
        ConfiguracionResponse configuracionResponse = new ConfiguracionResponse();
        Optional<Parametro> parameter =  parametroRepository.findAll().stream().findFirst();
        List<Card> cardList = cardRepository.findAll();
        List<Tea> teas = teaRepository.findAll();
        if (parameter.isPresent()) {
            Parametro param = parameter.get();
            configuracionResponse.setCuotas(
                    IntStream.range(param.getInit(), param.getEnd()).boxed().collect(Collectors.toList()));
        }
        if (!cardList.isEmpty()) {
            configuracionResponse.setTarjetas(cardList);
        }

        if (!teas.isEmpty()) {
            configuracionResponse.setTeas(teas);
        }
        return configuracionResponse;
    }
}
