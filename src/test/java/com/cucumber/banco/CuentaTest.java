package com.cucumber.banco;



import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CuentaTest {

    @Test
    public void extraerMontoNegativo(){

        assertThrows(RuntimeException.class , () ->{
            Cuenta c = new Cuenta(new BigDecimal(1000));
            c.extraer(new BigDecimal(-1000));
        });
    }


}
