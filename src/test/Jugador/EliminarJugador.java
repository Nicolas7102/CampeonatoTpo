package test.Jugador;

import controlador.Controlador;

public class EliminarJugador {

    public static void main(String[] args) {
        Controlador.getInstance().eliminarJugador(1021);
        System.out.println("\nFunciona");
    }
    
}
