package com.cucumber.banco.bdd.runners.backendRunnner;

import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.domain.Movimiento;
import com.cucumber.banco.domain.TipoMovimiento;
import com.cucumber.banco.port.ActualizarCuentaPort;
import com.cucumber.banco.port.BuscarCuentaPort;
import com.cucumber.banco.port.db.RepositorioCuentaEnMemoria;
import com.cucumber.banco.servicios.InterfazDeposito;
import com.cucumber.banco.servicios.ServicioDeposito;
import helpers.CuentaHolder;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositosBackendRunner implements com.cucumber.banco.bdd.runners.DepositosRunner {

    private Cuenta unaCuentaPropia = CuentaHolder.getInstace().getCuenta();
    private BuscarCuentaPort buscarCuentaPort = RepositorioCuentaEnMemoria.getInstance();
    private ActualizarCuentaPort actualizarCuentaPort = RepositorioCuentaEnMemoria.getInstance();
    private InterfazDeposito interfazDeposito = new ServicioDeposito(actualizarCuentaPort, buscarCuentaPort);


    @Override
    public void deposito(BigDecimal monto) {

        interfazDeposito.depositar(unaCuentaPropia.getNumeroCuenta(), monto);
    }



    @Override
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


    @Override
    public void se_agrego_el_movimiento_de_interes_a_la_cuenta(BigDecimal monto) {

        List<Movimiento> movimientos = unaCuentaPropia.obtenerMovimientos();
        Movimiento elMovimiento= movimientos.get(0);
        assertEquals(monto.compareTo(elMovimiento.getMonto()),0);
        assertEquals(TipoMovimiento.INTERES_COBRADO, elMovimiento.getTipo());
    }


    @Override
    public void no_tengo_el_movimiento_por_elinteres_agrego() {

        assertEquals(1, unaCuentaPropia.obtenerMovimientos().size());
    }
}
