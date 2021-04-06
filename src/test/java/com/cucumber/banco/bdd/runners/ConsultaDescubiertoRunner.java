package com.cucumber.banco.bdd.runners;

import java.math.BigDecimal;

public interface ConsultaDescubiertoRunner {

    void consulto_el_descubierto();
    void el_resultado_es(BigDecimal elMontoQueSeGiroEnDescubierto);
}
