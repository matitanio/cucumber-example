package com.cucumber.banco.domain;

import com.cucumber.banco.exceptions.SaldoInsuficiente;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cuenta {

    private BigDecimal saldo;
    private List<Movimiento> movimientos;
    private List<Acuerdo> acuerdos;
    private String numeroCuenta;

    public Cuenta(String id, BigDecimal saldo) {
        this.saldo = saldo;
        this.movimientos = new ArrayList<>();
        this.acuerdos = new ArrayList<>();
        numeroCuenta = id;
    }

    public BigDecimal consultarSaldo() {
        return saldo.setScale(2, RoundingMode.CEILING);
    }

    public void depositar(BigDecimal monto){

       ingresarDinerdo(monto, TipoMovimiento.DEPOSITO);
    }

    public void recibirTransferencia(BigDecimal monto){

        ingresarDinerdo(monto, TipoMovimiento.TRANSFERENCIA);
    }

    private void ingresarDinerdo(BigDecimal monto, TipoMovimiento tipoMovimiento){

        if(tengoSaldoNegativoYAcuerdoConIntres()){
            Acuerdo acuerdo = buscarAcuerdoQueAplica();
            BigDecimal montoInteres = calcularMontoInteres(acuerdo);

            this.saldo = this.saldo.subtract(montoInteres);
            this.movimientos.add(new Movimiento(TipoMovimiento.INTERES_COBRADO, montoInteres));
        }
        this.saldo = this.saldo.add(monto);
        this.movimientos.add(new Movimiento(tipoMovimiento, monto));
    }

    private BigDecimal calcularMontoInteres(Acuerdo acuerdo) {
        return this.saldo.multiply(acuerdo.getInteres())
                        .divide(new BigDecimal(100)).negate().setScale(2);
    }

    private boolean tengoSaldoNegativoYAcuerdoConIntres() {
        return this.saldo.compareTo(BigDecimal.ZERO) < 0  && tengoAlgunAcuerdoConteres();
    }


    private Boolean tengoAlgunAcuerdoConteres(){

        for (Acuerdo acuerdo:this.acuerdos) {
            if(saldo.negate().compareTo(acuerdo.getMontoAcuerdo()) >=0 && acuerdo.getInteres().compareTo(BigDecimal.ZERO) != 0){
                return true;
            }
        }
        return false;
    }

    private Acuerdo buscarAcuerdoQueAplica(){

        for (Acuerdo acuerdo:this.acuerdos) {
            if(saldo.negate().compareTo(acuerdo.getMontoAcuerdo()) >=0 && acuerdo.getInteres().compareTo(BigDecimal.ZERO) != 0){
                return acuerdo;
            }
        }

        //TODO: errores fatales
        throw  new RuntimeException("Paso algo con los acuerdos");
    }

    public List<Movimiento> obtenerMovimientos(){

        return this.movimientos;
    }

    public void agregarAcuerdo(Acuerdo acuerdo) {
        this.acuerdos.add(acuerdo);
    }

    public void extraer(BigDecimal montoExtraccion, TipoMovimiento origenExtraccion) {


        if(montoExtraccion.signum() < 0){
            throw  new RuntimeException("no se puede extrar negativo");
        }

        notTieneAcuerdoYElSaldoEsInsuficiente(montoExtraccion);

        if(tieneAcuerdo() && noTieneSaldo(montoExtraccion)){
            throw new SaldoInsuficiente("Saldo Insuficiente");
        }

        this.saldo = this.saldo.subtract(montoExtraccion);
        this.movimientos.add(new Movimiento(origenExtraccion, montoExtraccion.negate()));
    }

    private boolean tieneAcuerdo() {
        return !noTieneAcuerdo();
    }

    private boolean noTieneSaldo(BigDecimal montoExtraccion) {

        BigDecimal montoTentativo = this.saldo.subtract(montoExtraccion).abs();

        for(Acuerdo a  : acuerdos){
            if(a.getMontoAcuerdo().subtract(montoTentativo).signum() > 0){
                return false;
            }

        }
        return true;
    }

    private void notTieneAcuerdoYElSaldoEsInsuficiente(BigDecimal montoExtraccion) {

        if(noTieneAcuerdo() && this.saldo.subtract(montoExtraccion).signum() < 0){
            throw new SaldoInsuficiente();
        }
    }


    private boolean noTieneAcuerdo() {
        return this.acuerdos==null || this.acuerdos.size() == 0;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}
