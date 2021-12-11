package test.Jugador;
import java.sql.Date;

import controlador.Controlador;
import daos.ClubDao;

public class crearJugador {

    public static void main(String[] args) {

        Date f = new Date(1-1-2010);
        Controlador.getInstance().crearJugador("DNI", "112233", "Nombre4", "Apellido4", ClubDao.getInstance().getClubById(101010), f, 1);
        //Fecha no funciona y categoria devuelve -31 ¿?
        System.out.println("\nFunciona");
    }
    
}
