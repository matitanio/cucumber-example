package com.cucumber.banco.bdd;

import com.cucumber.banco.domain.Acuerdo;
import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.port.ActualizarCuentaPort;
import com.cucumber.banco.port.BuscarCuentaPort;
import com.cucumber.banco.port.db.RepositorioCuentaEnMemoria;
import helpers.CuentaHolder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasosCuenta {

    private BuscarCuentaPort buscarCuentaPort = RepositorioCuentaEnMemoria.getInstance();
    private ActualizarCuentaPort actualizarCuentaPort = RepositorioCuentaEnMemoria.getInstance();


    @Given("la cuenta {string} tiene un saldo de {}")
    public void una_cuenta_propia(String idCuenta, BigDecimal saldoInicial) {

        Cuenta cuenta = new Cuenta(idCuenta,saldoInicial);
        actualizarCuentaPort.actualizarCuenta(cuenta);
        CuentaHolder.getInstace().setCuenta(cuenta);
    }

    @And("no tiene acuerdo")
    public void no_tiene_acuerdo() {
        //TODO: REVISAR ESTO
    }

    @And("un acuerdo en descubierto sin interes hasta {}")
    public void una_cuenta_tinen_un_acuerdo_sin_interes(BigDecimal montoAcuerdo) {
        unaCuentaPropia().agregarAcuerdo(new Acuerdo(montoAcuerdo, BigDecimal.ZERO));
    }

    @And("un acuerdo en descubierto por {} con interes de {} %")
    public void una_cuenta_tinen_un_acuerdo(BigDecimal montoAcuerdo, BigDecimal interes) {

        unaCuentaPropia().agregarAcuerdo(new Acuerdo(montoAcuerdo, interes));
    }


    @Then("El saldo de mi cuenta es de {}")
    public void el_saldo_de_mi_cuenta_es_valido(BigDecimal saldo) {

        assertEquals(saldo,unaCuentaPropia().consultarSaldo());
    }

    private Cuenta unaCuentaPropia(){
        return buscarCuentaPort.buscarCuentaPorId("0000000001");
    }
}
