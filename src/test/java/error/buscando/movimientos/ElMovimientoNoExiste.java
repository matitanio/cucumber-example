package error.buscando.movimientos;

public class ElMovimientoNoExiste extends RuntimeException{

    public ElMovimientoNoExiste() {
        super();
    }

    public ElMovimientoNoExiste(String message) {
        super(message);
    }
}
