package test.Jugador;

import controlador.Controlador;

public class EliminarJugadoresDesdeClub {

    public static void main(String[] args) {
        Controlador.getInstance().eliminarJugadoresDesdeClub(101010);
        System.out.println("\nFunciona");
    }
    
}