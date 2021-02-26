package com.hans.simulador.prestamo.business;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrestamoServiceTest {

    private double calculateTem(Double tea) {
        return Math.pow(1+tea, 0.083333)-1;
    }

    private double calculateFrc(Double tem, Integer period) {
        var dividendo =  tem * Math.pow(1+tem,period);
        var divisor = Math.pow(1+tem,period)-1;
        return dividendo/divisor;
    }

    private double calculateCuot(Double frc, Double mont, Double itf) {
        return (frc*mont) + itf;
    }

    @Test
    public void tem() {

        var tem =  calculateTem(99.00);

        var frc = calculateFrc(round(tem,3), 2);

        //cuota
        var cuot = calculateCuot(frc, 5000.0, 0.005);

        assertEquals( 4365.94, round(cuot,2));

    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}