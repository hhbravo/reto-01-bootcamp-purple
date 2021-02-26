package com.hans.simulador.prestamo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class User {
    @Id
    private Integer id;
    @Column(name = "documento")
    private String document;

    public User() {
    }

    public User(Integer id, String document) {
        this.id = id;
        this.document = document;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
