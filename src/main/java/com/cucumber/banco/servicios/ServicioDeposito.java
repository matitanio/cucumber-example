package com.cucumber.banco.servicios;

import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.port.ActualizarCuentaPort;
import com.cucumber.banco.port.BuscarCuentaPort;

import java.math.BigDecimal;

public class ServicioDeposito implements InterfazDeposito {

    private ActualizarCuentaPort actualizarCuentaPort;
    private BuscarCuentaPort buscarCuentaPort;

    public ServicioDeposito(ActualizarCuentaPort actualizarCuentaPort, BuscarCuentaPort buscarCuentaPort) {
        this.actualizarCuentaPort = actualizarCuentaPort;
        this.buscarCuentaPort = buscarCuentaPort;
    }

    @Override
    public void depositar(String idCuenta, BigDecimal monto) {

       Cuenta unaCuenta =  buscarCuentaPort.buscarCuentaPorId(idCuenta);

       unaCuenta.depositar(monto);
       actualizarCuentaPort.actualizarCuenta(unaCuenta);
    }
}
