package com.cucumber.banco.bdd.runners;

import java.math.BigDecimal;

public interface DepositosRunner {

    void deposito(BigDecimal monto);

    void se_agrego_el_movimiento_de_deposito_a_la_cuenta(BigDecimal monto);

    void se_agrego_el_movimiento_de_interes_a_la_cuenta(BigDecimal monto);

    void no_tengo_el_movimiento_por_elinteres_agrego();
}
