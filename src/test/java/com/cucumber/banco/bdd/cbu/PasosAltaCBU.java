package com.cucumber.banco.bdd.cbu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosAltaCBU {

    @Given("la cuenta {string}")
    public void la_cuenta(String string) {
        //throw new io.cucumber.java.PendingException();
    }

    @Given("el cbu es valido y existe")
    public void el_cbu_es_valido_y_existe() {
        //throw new io.cucumber.java.PendingException();
    }

    @When("agrego el cbu a la lista de destinatarios")
    public void agrego_el_cbu_a_la_lista_de_destinatarios() {
       // throw new io.cucumber.java.PendingException();
    }

    @Then("el cbu queda guardado en la lista de destinatarios")
    public void el_cbu_queda_guardado_en_la_lista_de_destinatarios() {
        throw new io.cucumber.java.PendingException();
    }

}
