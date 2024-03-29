package com.cucumber.banco.bdd.runners.backendRunnner;

import com.cucumber.banco.bdd.runners.backendRunnner.helpers.BuscarPrimerMovimiento;
import com.cucumber.banco.bdd.runners.ExtraccionRunner;
import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.domain.Movimiento;
import com.cucumber.banco.domain.TipoMovimiento;
import com.cucumber.banco.exceptions.SaldoInsuficiente;
import com.cucumber.banco.port.ActualizarCuentaPort;
import com.cucumber.banco.port.BuscarCuentaPort;
import com.cucumber.banco.port.db.RepositorioCuentaEnMemoria;
import com.cucumber.banco.servicios.InterfazExtraccion;
import com.cucumber.banco.servicios.ServicioExtraccion;
import helpers.CuentaHolder;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtraccionBackendRunner implements ExtraccionRunner {

    private Cuenta unaCuentaPropia = CuentaHolder.getInstace().getCuenta();

    private BuscarCuentaPort buscarCuentaPort = RepositorioCuentaEnMemoria.getInstance();
    private ActualizarCuentaPort actualizarCuentaPort = RepositorioCuentaEnMemoria.getInstance();
    private InterfazExtraccion interfazExtraccion = new ServicioExtraccion(actualizarCuentaPort, buscarCuentaPort);


    public void extraigo_en_la_cuenta(BigDecimal montoExtraccion) {

        interfazExtraccion.extraer(unaCuentaPropia.getNumeroCuenta(), montoExtraccion);
    }

    public void tengo_el_movimiento_de_extraccion_por_en_mi_lista_de_movimientos(BigDecimal deLaExtraccion) {

        buscarElPrimerMovimiento()
                .enLaLista(deLosMovimientosDeLaCuenta())
                .conElMonto(deLaExtraccion)
                .yDelTipo(extraccion());
    }

    private TipoMovimiento extraccion(){
        return TipoMovimiento.EXTRACCION;
    }
    private List<Movimiento> deLosMovimientosDeLaCuenta() {
        return unaCuentaPropia.obtenerMovimientos();
    }

    private BuscarPrimerMovimiento buscarElPrimerMovimiento(){
        return new BuscarPrimerMovimiento();
    }


    public void intengo_extraer(BigDecimal monto) {

        assertThrows(SaldoInsuficiente.class,()->{
            unaCuentaPropia.extraer(monto, TipoMovimiento.EXTRACCION);
        });
    }
}
