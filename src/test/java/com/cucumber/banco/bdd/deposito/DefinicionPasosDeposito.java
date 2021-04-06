package com.cucumber.banco.bdd.deposito;

import com.cucumber.banco.bdd.runners.DepositosRunner;
import com.cucumber.banco.bdd.runners.backendRunnner.DepositosBackendRunner;


import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.math.BigDecimal;

public class DefinicionPasosDeposito {


    DepositosRunner depositosRunner = new DepositosBackendRunner();

    @When("Deposito {} en la cuenta")
    public void deposito(BigDecimal monto) {

        depositosRunner.deposito(monto);
    }


    @And("Tengo el movimiento por {} en mi lista de movimientos")
    public void se_agrego_el_movimiento_de_deposito_a_la_cuenta(BigDecimal monto) {

       depositosRunner.se_agrego_el_movimiento_de_deposito_a_la_cuenta(monto);
    }

    @And("Tengo el movimiento por {} de interes por el descubierto")
    public void se_agrego_el_movimiento_de_interes_a_la_cuenta(BigDecimal monto) {

        depositosRunner.se_agrego_el_movimiento_de_interes_a_la_cuenta(monto);
    }

    @And("No tengo el movimiento de interes")
    public void no_tengo_el_movimiento_por_elinteres_agrego() {

        depositosRunner.no_tengo_el_movimiento_por_elinteres_agrego();
    }
}
