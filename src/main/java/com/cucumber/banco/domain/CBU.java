package com.cucumber.banco.domain;

import ch.qos.logback.core.joran.spi.ElementSelector;
import com.cucumber.banco.exceptions.CBUInvalidoException;

public class CBU {

    private String numero;

    private CBU(String numero){
        this.numero = numero;
    }

    public String getNumero(){
        return this.numero;
    }

    public static class CBUBuilder {

        private String cbu;

        public  CBUBuilder(String cbu){

            this.cbu = cbu;
        }

        public CBU build(){

            if(validarCBU(this.cbu))
                 return new CBU(this.cbu);
            else
                throw new CBUInvalidoException();
        }


        private static Boolean validarCBU(String cbu){
            return validarLargoCBU(cbu) && validarCodigoBanco(cbu.substring(0,8)) && validarCuenta(cbu.substring(8,22));
        }

        private static Boolean validarLargoCBU(String cbu) {
            if (cbu.length() != 22)
                return false;
            return true;
        }

        private static Boolean validarCodigoBanco(String codigo) {
            Integer suma;
            Integer diferencia;
            if (codigo.length() != 8)
                return false;
            char[] banco = codigo.substring(0,3).toCharArray();
            Integer digitoVerificador1 = charToInt(codigo.toCharArray()[3]);
            char[] sucursal = codigo.substring(4,7).toCharArray();
            Integer digitoVerificador2 = charToInt(codigo.toCharArray()[7]);
            suma = charToInt(banco[0]) * 7 + charToInt(banco[1]) * 1 + charToInt(banco[2]) * 3 + digitoVerificador1 * 9 + charToInt(sucursal[0]) * 7 + charToInt(sucursal[1]) * 1 + charToInt(sucursal[2]) * 3;
            diferencia = 10 - (suma % 10);
            return diferencia == digitoVerificador2;
        }

        private static Boolean validarCuenta(String cuenta) {
            if(cuenta.length()!=14)
                return false;
            Integer digitoVerificador = charToInt(cuenta.toCharArray()[13]);
            Integer suma;
            Integer diferencia;
            char[] cuentaArray = cuenta.toCharArray();
            suma = charToInt(cuentaArray[0]) * 3 + charToInt(cuentaArray[1]) * 9 + charToInt(cuentaArray[2]) * 7
                    + charToInt(cuentaArray[3]) * 1 + charToInt(cuentaArray[4]) * 3 + charToInt(cuentaArray[5]) * 9
                    + charToInt(cuentaArray[6]) * 7 + charToInt(cuentaArray[7]) * 1 + charToInt(cuentaArray[8]) * 3
                    + charToInt(cuentaArray[9]) * 9 + charToInt(cuentaArray[10]) * 7 + charToInt(cuentaArray[11]) * 1
                    + charToInt(cuentaArray[12]) * 3;
            diferencia = 10 - (suma % 10);
            return diferencia == digitoVerificador;
        }

        private static Integer charToInt(char ch){
            return Integer.parseInt(String.valueOf(ch));
        }

    }

}

