package com.cucumber.banco.servicios;

import java.math.BigDecimal;

public interface InterfazDeposito {

    void depositar(String idCuenta, BigDecimal monto);

}
