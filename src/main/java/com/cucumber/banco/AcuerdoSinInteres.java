package com.cucumber.banco;

import java.math.BigDecimal;

public class AcuerdoSinInteres extends Acuerdo {

    public AcuerdoSinInteres(BigDecimal montoAcuerdo) {
        super(montoAcuerdo, BigDecimal.ZERO);
    }

}
