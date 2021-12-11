package test.Representante;

import controlador.Controlador;

public class EliminarRepresentante {

    public static void main(String[] args) {
        Controlador.getInstance().eliminarRepresentante(1);
        System.out.println("\nFunciona");
    }
    
}
