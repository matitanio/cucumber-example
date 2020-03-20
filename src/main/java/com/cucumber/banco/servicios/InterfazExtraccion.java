package com.cucumber.banco.servicios;

import java.math.BigDecimal;

public interface InterfazExtraccion {

    void extraer(String cuentaId, BigDecimal monto);
}
