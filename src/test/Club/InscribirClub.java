package test.Club;

import controlador.Controlador;

public class InscribirClub {

    public static void main(String[] args) {

        Controlador.getInstance().inscribirClub(321, 13);
        System.out.println("\nFunciona");
    }
    
}