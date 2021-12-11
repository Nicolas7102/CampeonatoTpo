package test.Campeonato;

import java.sql.Date;

import controlador.Controlador;

public class CrearCampeonato {

    public static void main(String[] args) {
        Date d1 = new Date(2010-10-10);
        Date d2 = new Date(2010-11-10);
        Controlador.getInstance().crearCampeonato("Descripcion 1", d1, d2, "activo");
        System.out.println("\nFunciona");
    }
    
}