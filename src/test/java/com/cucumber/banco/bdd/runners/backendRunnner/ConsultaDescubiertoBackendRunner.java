package com.cucumber.banco.bdd.runners.backendRunnner;

import com.cucumber.banco.bdd.runners.ConsultaDescubiertoRunner;
import com.cucumber.banco.domain.Cuenta;
import helpers.CuentaHolder;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultaDescubiertoBackendRunner implements ConsultaDescubiertoRunner {

    private Cuenta unaCuentaPropia = CuentaHolder.getInstace().getCuenta();

    private BigDecimal resultadoDescubierto ;

    @Override
    public void consulto_el_descubierto() {

        resultadoDescubierto = unaCuentaPropia.consultarDescubiertoDispobible();
    }

    @Override
    public void el_resultado_es(BigDecimal elMontoEsperadoParaGirarEnDescubierto){

        assertEquals(elMontoEsperadoParaGirarEnDescubierto, resultadoDescubierto);
    }
}
