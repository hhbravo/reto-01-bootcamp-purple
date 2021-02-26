package com.hans.simulador.prestamo.entity;

public class PrestamoResponse {

    private Double cuota;
    private String moneda;
    private String primeraCuota;
    private String estado;

    public PrestamoResponse() {
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getPrimeraCuota() {
        return primeraCuota;
    }

    public void setPrimeraCuota(String primeraCuota) {
        this.primeraCuota = primeraCuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
