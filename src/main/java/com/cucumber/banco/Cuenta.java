package com.cucumber.banco;

import com.cucumber.banco.exceptions.SaldoInsuficiente;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cuenta {

    private BigDecimal saldo;
    private List<Movimiento> movimientos;
    private List<Acuerdo> acuerdos;

    public Cuenta(BigDecimal saldo) {
        this.saldo = saldo;
        this.movimientos = new ArrayList<>();
        this.acuerdos = new ArrayList<>();
    }

    public BigDecimal consultarSaldo() {
        return saldo.setScale(2, RoundingMode.CEILING);
    }

    public void depositar(BigDecimal monto){

        if(tengoSaldoNegativoYAcuerdoConIntres()){
            Acuerdo acuerdo = buscarAcuerdoQueAplica();
            BigDecimal montoInteres = this.saldo.multiply(acuerdo.getInteres())
                    .divide(new BigDecimal(100)).negate().setScale(2);

            this.saldo = this.saldo.subtract(montoInteres);
            this.movimientos.add(new Movimiento(TipoMovimiento.INTERES_COBRADO, montoInteres));
        }
        this.saldo = this.saldo.add(monto);
        this.movimientos.add(new Movimiento(TipoMovimiento.DEPOSITO, monto));
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

    public void extraer(BigDecimal montoExtraccion) {

        if(montoExtraccion.signum() < 0){
            throw  new RuntimeException("no se puede extrar negativo");
        }

        notTieneAcuerdoYElSaldoEsInsuficiente(montoExtraccion);

        if(tieneAcuerdo() && noTieneSaldo(montoExtraccion)){
            throw new SaldoInsuficiente();
        }

        this.saldo = this.saldo.subtract(montoExtraccion);
        this.movimientos.add(new Movimiento(TipoMovimiento.EXTRACCION, montoExtraccion));
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

}
