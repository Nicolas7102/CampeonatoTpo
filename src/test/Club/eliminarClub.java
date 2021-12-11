package test.Club;

import controlador.Controlador;

public class eliminarClub {

    public static void main(String[] args) {

        Controlador.getInstance().eliminarClub(123);
        System.out.println("\nFunciona");
    }
    
}