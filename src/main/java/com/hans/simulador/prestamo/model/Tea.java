package com.hans.simulador.prestamo.model;

import javax.persistence.*;

@Entity
@Table(name = "tea")
public class Tea {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "valor")
    private String value;
    private String tasa;

    public Tea() {
    }

    public Tea(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
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
