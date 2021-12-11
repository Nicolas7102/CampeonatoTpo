package test.Jugador;

import java.sql.Date;

import controlador.Controlador;

public class ModificarJugador {

    public static void main(String[] args) {
        Date f = new Date(1-1-2010);
        Controlador.getInstance().modificarJugador(1022, "ABC", "112233", "Nombre2", "Apellido2", 555, f, 3);
        System.out.println("\nFunciona");
    }
    
}