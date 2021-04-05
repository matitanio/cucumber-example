package com.cucumber.banco.bdd.runners;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;

public interface TransferenciaRunner {
    @Given("la cuenta {string} con saldo de {}")
    void la_cuenta_con_saldo_de(String numeroCuenta, BigDecimal saldo);

    @When("transfiero {} de la cuenta {string} a la cuenta {string}")
    void transfiero_de_la_cuenta_de_la_cuenta_a_la_cuenta(BigDecimal monto, String cuentaOrigen, String cuentaDestino);

    @Then("El saldo de la cuenta {string} es {}")
    void el_saldo_de_la_cuenta_es(String idCuenta, BigDecimal saldo);

    @Then("Tengo el movimiento de transferencia por {} en la lista de movimientos de la cuenta {string}")
    void tengo_el_movimiento_de_transferencia_por_en_la_lista_de_movimientos_de_la_cuenta(BigDecimal montoMovimiento, String cuenta);

    @When("intento transfereir {} de la cuenta {string} a la cuenta {string}")
    void intento_transfereir_de_la_cuenta_a_la_cuenta(BigDecimal monto, String cuentaOrigen, String cuentaDestino);

    @Then("obtengo el mensaje {string}")
    void obtengo_el_mensaje(String mensajeEsperado);
}
