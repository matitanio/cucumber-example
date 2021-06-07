package com.cucumber.banco.bdd.runners.backendRunnner;

import com.cucumber.banco.bdd.runners.TransferenciaRunner;
import com.cucumber.banco.comandos.ComandoTransfencia;
import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.domain.Movimiento;
import com.cucumber.banco.domain.TipoMovimiento;
import com.cucumber.banco.exceptions.SaldoInsuficiente;
import com.cucumber.banco.port.ActualizarCuentaPort;
import com.cucumber.banco.port.BuscarCuentaPort;
import com.cucumber.banco.port.db.RepositorioCuentaEnMemoria;
import com.cucumber.banco.servicios.InterfazTransferencia;
import com.cucumber.banco.servicios.ServicioTransferencia;
import error.buscando.movimientos.ElMovimientoNoExiste;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TransferenciasBackendRunner implements TransferenciaRunner {

    private BuscarCuentaPort buscarCuentaPort = RepositorioCuentaEnMemoria.getInstance();
    private ActualizarCuentaPort actualizarCuentaPort = RepositorioCuentaEnMemoria.getInstance();
    private InterfazTransferencia transferencia = new ServicioTransferencia(buscarCuentaPort, actualizarCuentaPort);

    public void la_cuenta_con_saldo_de(String numeroCuenta, BigDecimal saldo) {

        actualizarCuentaPort.actualizarCuenta(new Cuenta(numeroCuenta, saldo));
    }


    public void transfiero_de_la_cuenta_de_la_cuenta_a_la_cuenta(BigDecimal monto, String cuentaOrigen, String cuentaDestino) {

        ComandoTransfencia transfencia = new ComandoTransfencia(cuentaOrigen, cuentaDestino, monto);

        transferencia.transferir(transfencia);
    }

    public void el_saldo_de_la_cuenta_es(String idCuenta, BigDecimal saldo) {

        Cuenta c = buscarCuentaPort.buscarCuentaPorId(idCuenta);

        assertEquals(saldo, c.consultarSaldo());
    }

    public void tengo_el_movimiento_de_transferencia_por_en_la_lista_de_movimientos_de_la_cuenta(BigDecimal montoMovimiento, String cuenta) {

        List<Movimiento> movimientoList = buscarCuentaPort.buscarCuentaPorId(cuenta).obtenerMovimientos();

        Movimiento movimiento = movimientoList.get(0);
        assertEquals(montoMovimiento, movimiento.getMonto());
        assertEquals(TipoMovimiento.TRANSFERENCIA, movimiento.getTipo());


    }

    private String mensajeErrorPorFaltaDeSaldo;

    public void intento_transfereir_de_la_cuenta_a_la_cuenta(BigDecimal monto, String cuentaOrigen, String cuentaDestino) {

        ComandoTransfencia transfencia = new ComandoTransfencia(cuentaOrigen, cuentaDestino, monto);

        try {
            transferencia.transferir(transfencia);
            fail("No se debe dejar transferir");
        }catch (SaldoInsuficiente si){
            mensajeErrorPorFaltaDeSaldo = si.getMessage();
        }catch (Exception e){
            fail("Fallo por otro motivo que no fue la falta de saldo");
        }
    }


    public void obtengo_el_mensaje(String mensajeEsperado) {

        assertEquals(mensajeEsperado, mensajeErrorPorFaltaDeSaldo);
    }
}
