package com.cucumber.banco.bdd.runners.backendRunnner.helpers;

import com.cucumber.banco.domain.Movimiento;
import com.cucumber.banco.domain.TipoMovimiento;
import error.buscando.movimientos.ElMovimientoNoExiste;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuscarPrimerMovimiento {

    List<Movimiento> movimientoList;
    private Movimiento movimiento;

    public BuscarPrimerMovimiento enLaLista(List<Movimiento> movimientoList){
        this.movimientoList = movimientoList;

        try{
            this.movimiento = movimientoList.get(0);
        }catch(IndexOutOfBoundsException ie){
            throw  new ElMovimientoNoExiste("En la lista de movimientos");
        }

        return this;
    }

    public BuscarPrimerMovimiento conElMonto(BigDecimal monto){
        assertEquals(monto, movimiento.getMonto());
        return this;
    }

    public BuscarPrimerMovimiento yDelTipo(TipoMovimiento tipoMovimiento){
        assertEquals(tipoMovimiento, movimiento.getTipo());
        return this;
    }
}
