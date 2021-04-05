package com.cucumber.banco.bdd.deposito;

import com.cucumber.banco.bdd.runners.DepositosRunner;
import com.cucumber.banco.bdd.runners.backendRunnner.DepositosBackendRunner;
import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.domain.Movimiento;
import com.cucumber.banco.domain.TipoMovimiento;
import com.cucumber.banco.port.ActualizarCuentaPort;
import com.cucumber.banco.port.BuscarCuentaPort;
import com.cucumber.banco.port.db.RepositorioCuentaEnMemoria;
import com.cucumber.banco.servicios.InterfazDeposito;
import com.cucumber.banco.servicios.ServicioDeposito;
import helpers.CuentaHolder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
