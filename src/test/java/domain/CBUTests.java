package domain;

import com.cucumber.banco.domain.CBU;
import com.cucumber.banco.exceptions.CBUInvalidoException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CBUTests {

    @Test
    public void crearUnCBUValido(){

        String cbuValido = "0720762688000035668154";
        CBU cbu = new CBU.CBUBuilder(cbuValido).build();

        assertEquals(cbuValido, cbu.getNumero());
    }


    @Test
    public void crearUnCBUInValido(){

        String cbuValido = "072076268800003566815";

        assertThrows(CBUInvalidoException.class,() -> {
            new CBU.CBUBuilder(cbuValido).build();
        });

    }



}
