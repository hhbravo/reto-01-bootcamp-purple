package com.hans.simulador.prestamo.entity;


import com.hans.simulador.prestamo.model.Card;
import com.hans.simulador.prestamo.model.Tea;

import java.util.List;

public class ConfiguracionResponse {

    private List<Integer> cuotas;
    private List<Card> cards;
    private List<Tea> teas;

    public ConfiguracionResponse() {
    }

    public List<Tea> getTeas() {
        return teas;
    }

    public void setTeas(List<Tea> teas) {
        this.teas = teas;
    }

    public List<Integer> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Integer> cuotas) {
        this.cuotas = cuotas;
    }

    public List<Card> getTarjetas() {
        return cards;
    }

    public void setTarjetas(List<Card> cards) {
        this.cards = cards;
    }
}
