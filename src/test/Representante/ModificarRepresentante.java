package test.Representante;

import controlador.Controlador;

public class ModificarRepresentante {

    public static void main(String[] args) {
        Controlador.getInstance().modificarRepresentante(2, "Nombre1", "111222", 555);
        System.out.println("\nFunciona");
    }
    
}