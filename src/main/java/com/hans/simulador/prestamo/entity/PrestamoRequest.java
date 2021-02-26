package com.hans.simulador.prestamo.entity;

import javax.validation.constraints.*;

public class PrestamoRequest {
    @NotNull(message = "Dni es requerido")
    @Size(min = 8, max = 8, message = "El dni debe ser de 8 digitos")
    private String dni;
    @NotNull(message = "Tarjeta es requerido")
    private String tarjeta;
    @NotNull(message = "Moneda es requerido")
    private String moneda;
    @NotNull(message = "Monto es requerido")
    @Min(value = 100, message = "Valor del monto minimo es 100")
    @Max(value = 10000, message = "Valor del monto maxima es 10000")
    private Double monto;
    @NotNull(message = "Cuota es requerido")
    @Min(value = 1, message = "Ingresar una cuota valida")
    @Max(value = 36, message = "Ingresar una cuota valida")
    private Integer cuota;
    @NotNull(message = "Tea es requerido")
    private String tea;
    @NotNull(message = "Dia de pago es requerido")
    private String diaPago;
    @NotNull(message = "Fecha de pago es requerido")
    @Pattern(regexp = "^\\d{4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])"
    ,message = "Ingresar una fecha valida")
    private String fechaCompra;
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(String diaPago) {
        this.diaPago = diaPago;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
