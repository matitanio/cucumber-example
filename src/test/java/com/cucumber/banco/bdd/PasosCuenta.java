package com.cucumber.banco.bdd;

import com.cucumber.banco.Acuerdo;
import com.cucumber.banco.Cuenta;
import helpers.CuentaHolder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasosCuenta {


    @Given("una cuenta tiene un saldo de {}")
    public void una_cuenta_propia(BigDecimal saldoInicial) {

        CuentaHolder.getInstace().setCuenta( new Cuenta(saldoInicial));
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
        return CuentaHolder.getInstace().getCuenta();
    }
}
