package test.Representante;

import controlador.Controlador;
import daos.ClubDao;

public class crearRespresentante {

    public static void main(String[] args) {

        Controlador.getInstance().crearRepresentante("555666", "Nombre1", ClubDao.getInstance().getClubById(123));
        System.out.println("\nFunciona");
    }
}