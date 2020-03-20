package com.cucumber.banco.port;

import com.cucumber.banco.domain.Cuenta;

public interface BuscarCuentaPort {

    Cuenta buscarCuentaPorId(String id);
}
