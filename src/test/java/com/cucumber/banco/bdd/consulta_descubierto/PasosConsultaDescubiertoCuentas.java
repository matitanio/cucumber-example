package com.cucumber.banco.bdd.consulta_descubierto;

import com.cucumber.banco.bdd.runners.ConsultaDescubiertoRunner;
import com.cucumber.banco.bdd.runners.api.ConsultaDescubiertoApiRunner;
import com.cucumber.banco.bdd.runners.backendRunnner.ConsultaDescubiertoBackendRunner;
import com.cucumber.banco.bdd.runners.builders.ConsultaDescubiertoRunnerBuilder;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;

public class PasosConsultaDescubiertoCuentas {

    private ConsultaDescubiertoRunnerBuilder.ConsultaDescubiertoRunnerBuilders runnerType;
    private ConsultaDescubiertoRunner runner;

    public PasosConsultaDescubiertoCuentas(){
        String runnerName = System.getProperty("org.gradle.project.runner");
        runnerType = ConsultaDescubiertoRunnerBuilder.ConsultaDescubiertoRunnerBuilders.valueOf(runnerName);
        runner = ConsultaDescubiertoRunnerBuilder
                .getInstance().getRunner(runnerType);


    }



    @When("consulto el limite para girar en  descubierto")
    public void consulto_el_descubierto() {

        System.out.println("Corriendo con el runner [" + runnerType + "]");
        runner.consulto_el_descubierto();
    }

    @Then("el resultado es {}")
    public void el_resultado_es(BigDecimal elMontoEsperadoParaGirarEnDescubierto) {
        runner.el_resultado_es(elMontoEsperadoParaGirarEnDescubierto);
    }

}
