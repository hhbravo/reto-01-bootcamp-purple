package com.hans.simulador.prestamo.model;

import javax.persistence.*;

@Entity
@Table(name = "parametros")
public class Parametro {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "inicio")
    private Integer init;
    @Column(name = "fin")
    private Integer end;

    public Parametro() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getInit() {
        return init;
    }

    public Integer getEnd() {
        return end;
    }

}
