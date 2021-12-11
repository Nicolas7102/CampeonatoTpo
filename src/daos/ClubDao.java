package daos;

//import java.sql.PreparedStatement;

import org.hibernate.Session;

import entities.*;
import hibernate.HibernateUtil;
import modelo.*;

public class ClubDao {

    private static ClubDao instance;

    private ClubDao() {}

    public static ClubDao getInstance() {
        if(instance == null)
            instance = new ClubDao();
        return instance;
    }

    public void save(Club club) {
        ClubEntity aux = toEntity(club);
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(aux);
        s.getTransaction().commit();
        s.close();
    }

   /* public void delete(ClubEntity club) {
        //ClubEntity aux = toEntity(club);
        Session s = HibernateUtil.getSessionFactory().openSession();
        Integer id = club.getIdClub();
        s.beginTransaction();
        s.createQuery("DELETE FROM clubes WHERE idClub ='" + id + "'");
       // s.delete(aux);
        s.getTransaction().commit();
        s.close();
    }*/

    public void delete(Integer idClub)
{
    Session s = HibernateUtil.getSessionFactory().openSession();
    ClubEntity club;
    club = (ClubEntity)s.load(ClubEntity.class,idClub);
    s.delete(club);

    //This makes the pending delete to be done
    s.flush();
}
    
    ClubEntity toEntity(Club club) {
        ClubEntity ce = new ClubEntity(club.getIdClub(), club.getNombre(), club.getDireccion());
       /* ce.setIdClub(club.getIdClub());
        ce.setNombre(club.getNombre());
        ce.setDireccion(club.getDireccion());*/
        return ce;
    }

    public Club getClubById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        ClubEntity aux = (ClubEntity) s.createQuery("from ClubEntity ce where ce.idClub = " + id).uniqueResult();
        return toModelo(aux);
    }

    public ClubEntity getClubEntityById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        ClubEntity aux = (ClubEntity) s.createQuery("from ClubEntity ce where ce.idClub = " + id).uniqueResult();
        return aux;
    }

    Club toModelo(ClubEntity ce) {
        Club resultado = new Club(ce.getIdClub(), ce.getNombre(), ce.getDireccion());
        return resultado;
    }

}
