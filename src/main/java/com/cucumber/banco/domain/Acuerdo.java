package com.cucumber.banco.domain;

import java.math.BigDecimal;

public class Acuerdo {

    private BigDecimal montoAcuerdo;
    private BigDecimal interes;

    public Acuerdo(BigDecimal montoAcuerdo, BigDecimal interes) {

        this.montoAcuerdo = montoAcuerdo;
        this.interes = interes;
    }

    public BigDecimal getMontoAcuerdo() {
        return montoAcuerdo;
    }

    public BigDecimal getInteres() {
        return interes;
    }

}
