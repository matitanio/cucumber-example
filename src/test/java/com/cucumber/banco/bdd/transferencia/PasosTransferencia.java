package com.cucumber.banco.bdd.transferencia;

import com.cucumber.banco.bdd.runners.TransferenciaRunner;
import com.cucumber.banco.bdd.runners.backendRunnner.TransferenciasBackendRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;


public class PasosTransferencia{


    private TransferenciaRunner runner = new TransferenciasBackendRunner();

    @Given("la cuenta {string} con saldo de {}")
    public void la_cuenta_con_saldo_de(String numeroCuenta, BigDecimal saldo) {

        runner.la_cuenta_con_saldo_de(numeroCuenta,saldo);
    }


    @When("transfiero {} de la cuenta {string} a la cuenta {string}")
    public void transfiero_de_la_cuenta_de_la_cuenta_a_la_cuenta(BigDecimal monto, String cuentaOrigen, String cuentaDestino) {

        runner.transfiero_de_la_cuenta_de_la_cuenta_a_la_cuenta(monto, cuentaOrigen, cuentaDestino);
    }

    @Then("El saldo de la cuenta {string} es {}")
    public void el_saldo_de_la_cuenta_es(String idCuenta, BigDecimal saldo) {

        runner.el_saldo_de_la_cuenta_es(idCuenta, saldo);
    }

    @Then("Tengo el movimiento de transferencia por {} en la lista de movimientos de la cuenta {string}")
    public void tengo_el_movimiento_de_transferencia_por_en_la_lista_de_movimientos_de_la_cuenta(BigDecimal montoMovimiento, String cuenta) {

        runner.tengo_el_movimiento_de_transferencia_por_en_la_lista_de_movimientos_de_la_cuenta(montoMovimiento, cuenta);
    }


    @When("intento transfereir {} de la cuenta {string} a la cuenta {string}")
    public void intento_transfereir_de_la_cuenta_a_la_cuenta(BigDecimal monto, String cuentaOrigen, String cuentaDestino) {

       runner.intento_transfereir_de_la_cuenta_a_la_cuenta(monto, cuentaOrigen, cuentaDestino);
    }


    @Then("obtengo el mensaje {string}")
    public void obtengo_el_mensaje(String mensajeEsperado) {

        runner.obtengo_el_mensaje(mensajeEsperado);
    }


}
