package com.cucumber.banco.bdd.deposito;

import com.cucumber.banco.Cuenta;
import com.cucumber.banco.Movimiento;
import com.cucumber.banco.TipoMovimiento;
import helpers.CuentaHolder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefinicionPasosDeposito {

    private Cuenta unaCuentaPropia = CuentaHolder.getInstace().getCuenta();


    @When("Deposito {} en la cuenta")
    public void deposito(BigDecimal monto) {

        unaCuentaPropia.depositar(monto);
    }


    @And("Tengo el movimiento por {} en mi lista de movimientos")
    public void se_agrego_el_movimiento_de_deposito_a_la_cuenta(BigDecimal monto) {

        List<Movimiento> movimientos = unaCuentaPropia.obtenerMovimientos();
        Movimiento elMovimiento;

        if(movimientos.size() == 2){
            elMovimiento= movimientos.get(1);
        }else{
            elMovimiento = movimientos.get(0);
        }

        assertEquals(elMovimiento.getMonto().compareTo(monto), 0);
        assertEquals(elMovimiento.getTipo(), TipoMovimiento.DEPOSITO);
    }

    @And("Tengo el movimiento por {} de interes por el descubierto")
    public void se_agrego_el_movimiento_de_interes_a_la_cuenta(BigDecimal monto) {

        List<Movimiento> movimientos = unaCuentaPropia.obtenerMovimientos();
        Movimiento elMovimiento= movimientos.get(0);
        assertEquals(monto.compareTo(elMovimiento.getMonto()),0);
        assertEquals(TipoMovimiento.INTERES_COBRADO, elMovimiento.getTipo());
    }

    @And("No tengo el movimiento de interes")
    public void no_tengo_el_movimiento_por_elinteres_agrego() {

        assertEquals(1, unaCuentaPropia.obtenerMovimientos().size());
    }
}
