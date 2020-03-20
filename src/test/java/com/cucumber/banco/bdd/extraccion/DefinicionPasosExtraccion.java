package com.cucumber.banco.bdd.extraccion;

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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DefinicionPasosExtraccion {

    private Cuenta unaCuentaPropia = CuentaHolder.getInstace().getCuenta();

    private BuscarCuentaPort buscarCuentaPort = RepositorioCuentaEnMemoria.getInstance();
    private ActualizarCuentaPort actualizarCuentaPort = RepositorioCuentaEnMemoria.getInstance();
    private InterfazExtraccion interfazExtraccion = new ServicioExtraccion(actualizarCuentaPort, buscarCuentaPort);

    @When("Extraigo {} en la cuenta")
    public void extraigo_en_la_cuenta(BigDecimal montoExtraccion) {

        interfazExtraccion.extraer(unaCuentaPropia.getNumeroCuenta(), montoExtraccion);
    }

    @Then("Tengo el movimiento de extraccion por {} en mi lista de movimientos")
    public void tengo_el_movimiento_de_extraccion_por_en_mi_lista_de_movimientos(BigDecimal montoMovimiento) {

        List<Movimiento> movimientoList = unaCuentaPropia.obtenerMovimientos();
        Movimiento movimiento = movimientoList.get(0);

        assertEquals(montoMovimiento, movimiento.getMonto());
        assertEquals(TipoMovimiento.EXTRACCION, movimiento.getTipo());
    }

    @When("Intengo extraer {}")
    public void intengo_extraer(BigDecimal monto) {

        assertThrows(SaldoInsuficiente.class,()->{
            unaCuentaPropia.extraer(monto, TipoMovimiento.EXTRACCION);
        });
    }
}
