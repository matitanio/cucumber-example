package com.cucumber.banco.comandos;



import java.math.BigDecimal;

public class ComandoTransfencia {

    private String idCuentaOrigen;
    private String idCuentaDestino ;

    private BigDecimal montoTrasferencia;


    public ComandoTransfencia(String idCuentaOrigen, String idCuentaDestino, BigDecimal montoTrasferencia) {
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
        this.montoTrasferencia = montoTrasferencia;
    }


    public String getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    public void setIdCuentaOrigen(String idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
    }

    public String getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(String idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    public BigDecimal getMontoTrasferencia() {
        return montoTrasferencia;
    }

    public void setMontoTrasferencia(BigDecimal montoTrasferencia) {
        this.montoTrasferencia = montoTrasferencia;
    }
}
