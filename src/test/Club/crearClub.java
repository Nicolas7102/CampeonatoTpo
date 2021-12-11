package test.Club;

import controlador.Controlador;

public class crearClub {

    public static void main(String[] args) {

        Controlador.getInstance().crearClub(321, "chicago forever", "forever al 2000");
        System.out.println("\nFunciona");
    }
    
}
