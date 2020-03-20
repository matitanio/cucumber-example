package com.cucumber.banco.servicios;

import com.cucumber.banco.comandos.ComandoTransfencia;
import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.domain.TipoMovimiento;
import com.cucumber.banco.port.ActualizarCuentaPort;
import com.cucumber.banco.port.BuscarCuentaPort;

public class ServicioTransferencia implements InterfazTransferencia{


    private ActualizarCuentaPort actualizarCuentaPort;
    private BuscarCuentaPort buscarCuentaPort;

    public ServicioTransferencia(BuscarCuentaPort buscarCuentaPort, ActualizarCuentaPort actualizarCuentaPort) {
        this.buscarCuentaPort = buscarCuentaPort;
        this.actualizarCuentaPort = actualizarCuentaPort;
    }

    @Override
    public void transferir(ComandoTransfencia transferencia) {

        Cuenta origen = buscarCuentaPort.buscarCuentaPorId(transferencia.getIdCuentaOrigen());
        Cuenta destino = buscarCuentaPort.buscarCuentaPorId(transferencia.getIdCuentaDestino());

        //TODO: LOGICAS DE REVERSA Y DEMAS YERBAS
        origen.extraer(transferencia.getMontoTrasferencia(), TipoMovimiento.TRANSFERENCIA);
        destino.recibirTransferencia(transferencia.getMontoTrasferencia());

        actualizarCuentaPort.actualizarCuenta(origen);
        actualizarCuentaPort.actualizarCuenta(destino);
    }
}
