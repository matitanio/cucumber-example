package com.cucumber.banco;



import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.domain.TipoMovimiento;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CuentaTest {

    @Test
    public void extraerMontoNegativo(){

        assertThrows(RuntimeException.class , () ->{
            Cuenta c = new Cuenta("",new BigDecimal(1000));
            c.extraer(new BigDecimal(-1000), TipoMovimiento.EXTRACCION);
        });
    }


}
