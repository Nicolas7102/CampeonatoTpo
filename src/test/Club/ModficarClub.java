package test.Club;
import controlador.Controlador;

public class ModficarClub {

    public static void main(String[] args) {
        Controlador.getInstance().modificarClub(101010, "Club101010", "Direccion101010");
        System.out.println("\nFunciona");
    }
}
