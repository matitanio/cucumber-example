package com.cucumber.banco.bdd.runners.api;

import com.cucumber.banco.api.cuenta.CuentaResource;
import com.cucumber.banco.bdd.runners.ConsultaDescubiertoRunner;
import com.cucumber.banco.comandos.cuenta.ComandoConsultaDescubierto;
import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.port.BuscarCuentaPort;
import com.cucumber.banco.port.db.RepositorioCuentaEnMemoria;
import helpers.CuentaHolder;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultaDescubiertoApiRunner implements ConsultaDescubiertoRunner {

    private BuscarCuentaPort buscarCuentaPort = RepositorioCuentaEnMemoria.getInstance();
    private CuentaResource cuentaResource = new CuentaResource(buscarCuentaPort);

    private Cuenta unaCuentaPropia = CuentaHolder.getInstace().getCuenta();
    private ComandoConsultaDescubierto comandoConsultaDescubierto;


    @Override
    public void consulto_el_descubierto() {

        comandoConsultaDescubierto = cuentaResource.descubierto(unaCuentaPropia.getNumeroCuenta());
    }

    @Override
    public void el_resultado_es(BigDecimal elMontoEsperadoParaGirarEnDescubierto) {

        assertEquals(unaCuentaPropia.getNumeroCuenta(), comandoConsultaDescubierto.getNumeroCuenta());
        assertEquals(elMontoEsperadoParaGirarEnDescubierto, comandoConsultaDescubierto.getMontoDescubierto());
    }
}
