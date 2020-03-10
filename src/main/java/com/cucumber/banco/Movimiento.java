package com.cucumber.banco;

import java.math.BigDecimal;

public class Movimiento {

    private TipoMovimiento tipo;
    private BigDecimal monto;

    public Movimiento(TipoMovimiento tipo, BigDecimal monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }
}
