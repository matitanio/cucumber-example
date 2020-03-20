package com.cucumber.banco.port.db;

import com.cucumber.banco.domain.Cuenta;
import com.cucumber.banco.port.ActualizarCuentaPort;
import com.cucumber.banco.port.BuscarCuentaPort;

import java.util.HashMap;
import java.util.Map;

public class RepositorioCuentaEnMemoria implements ActualizarCuentaPort, BuscarCuentaPort {

    private Map<String, Cuenta> cuentas;

    private  RepositorioCuentaEnMemoria(){
        cuentas = new HashMap<>();
    }

    private static RepositorioCuentaEnMemoria instance;


    public static RepositorioCuentaEnMemoria getInstance(){
        if(instance == null){
            instance = new RepositorioCuentaEnMemoria();
        }
        return instance;
    }


    @Override
    public void actualizarCuenta(Cuenta c) {

        cuentas.put(c.getNumeroCuenta(), c);
    }

    @Override
    public Cuenta buscarCuentaPorId(String id) {

        return cuentas.get(id);
    }
}



