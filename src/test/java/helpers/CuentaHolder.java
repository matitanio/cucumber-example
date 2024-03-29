package helpers;

import com.cucumber.banco.domain.Cuenta;

public class CuentaHolder {

    private static CuentaHolder instance;
    private Cuenta cuenta;
    private CuentaHolder(){}

    public static CuentaHolder getInstace(){

        if(instance == null)
            instance = new CuentaHolder();

        return instance;
    }

    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta(){
        return this.cuenta;
    }


}
