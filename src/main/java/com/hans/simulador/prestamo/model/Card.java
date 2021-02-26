package com.hans.simulador.prestamo.model;

import javax.persistence.*;

@Entity
@Table(name = "tarjeta")
public class Card {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "valor")
    private String value;

    public Card() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
