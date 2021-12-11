package test.Club;

import daos.ClubDao;

public class EliminarClubDos {

    public static void main(String[] args) {
        
        ClubDao.getInstance().delete(999);
        System.out.println("\nFunciona");
    }
    
}
