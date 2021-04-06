package com.cucumber.banco.api.cuenta;


import com.cucumber.banco.comandos.cuenta.ComandoConsultaDescubierto;
import com.cucumber.banco.port.BuscarCuentaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CuentaResource {

    @Autowired
    private BuscarCuentaPort buscarCuentaPort;

    public CuentaResource(BuscarCuentaPort buscarCuentaPort) {
        this.buscarCuentaPort = buscarCuentaPort;
    }

    @GetMapping("/cuentas/{id}/descubierto")
    public ComandoConsultaDescubierto descubierto(@PathVariable String id) {

        return new ComandoConsultaDescubierto(id,
                buscarCuentaPort.buscarCuentaPorId(id).consultarDescubiertoDispobible());
    }
}
