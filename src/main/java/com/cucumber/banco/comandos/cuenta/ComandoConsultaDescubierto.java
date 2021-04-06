package com.cucumber.banco.comandos.cuenta;

import java.math.BigDecimal;

public class ComandoConsultaDescubierto {

    private String numeroCuenta;
    private BigDecimal montoDescubierto;

    public ComandoConsultaDescubierto(String numeroCuenta, BigDecimal montoDescubierto) {
        this.numeroCuenta = numeroCuenta;
        this.montoDescubierto = montoDescubierto;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getMontoDescubierto() {
        return montoDescubierto;
    }

    public void setMontoDescubierto(BigDecimal montoDescubierto) {
        this.montoDescubierto = montoDescubierto;
    }
}
