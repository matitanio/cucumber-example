package com.cucumber.banco.servicios;

import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.domain.TipoMovimiento;
import com.cucumber.banco.port.ActualizarCuentaPort;
import com.cucumber.banco.port.BuscarCuentaPort;

import java.math.BigDecimal;

public class ServicioExtraccion implements InterfazExtraccion {

    private ActualizarCuentaPort actualizarCuentaPort;
    private BuscarCuentaPort buscarCuentaPort;

    public ServicioExtraccion(ActualizarCuentaPort actualizarCuentaPort, BuscarCuentaPort buscarCuentaPort) {
        this.actualizarCuentaPort = actualizarCuentaPort;
        this.buscarCuentaPort = buscarCuentaPort;
    }

    @Override
    public void extraer(String cuentaId, BigDecimal monto) {

        Cuenta c = buscarCuentaPort.buscarCuentaPorId(cuentaId);
        c.extraer(monto, TipoMovimiento.EXTRACCION);
        actualizarCuentaPort.actualizarCuenta(c);
    }
}
