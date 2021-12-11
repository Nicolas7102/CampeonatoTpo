package test.Campeonato;

import java.sql.Date;

import controlador.Controlador;

public class ModificarCampeonato {

    public static void main(String[] args) {
        Date d1 = new Date(2010-10-10);
        Date d2 = new Date(2010-11-10);
        Controlador.getInstance().modificarCampeonato(13, "Descripcion2", d1, d2, null);
        System.out.println("\nFunciona");
    }

    
    
}
