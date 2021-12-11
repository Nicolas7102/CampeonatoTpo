package daos;

import org.hibernate.Session;
import entities.ResponsableEntity;
import hibernate.HibernateUtil;
import modelo.Responsable;

public class ResponsableDao {

    private static ResponsableDao instance;

    public static ResponsableDao getInstance() {
        if (instance == null)
            instance = new ResponsableDao();
        return instance;
}

    public void save(Responsable responsable) {
    ResponsableEntity aux = toEntity(responsable);
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    s.save(aux);
    s.getTransaction().commit();
    s.close();
}
    ResponsableEntity toEntity(Responsable responsable) {
        ResponsableEntity re = new ResponsableEntity();
        re.setClub(ClubDao.getInstance().getClubEntityById(responsable.getClub().getIdClub()));
        re.setDocumento(responsable.getDocumento());
        re.setNombre(responsable.getNombre());
        return re;
    }

    public Responsable getResponsableByLegajo(int legajo) {
        Session s = HibernateUtil.getSessionFactory().openSession();
            ResponsableEntity aux = (ResponsableEntity) s.createQuery("from ResponsableEntity where re.legajo = " + legajo).uniqueResult();
            return toModelo(aux);
    }

    Responsable toModelo(ResponsableEntity re) {
        Responsable resultado = new Responsable(re.getLegajo(), re.getDocumento(), re.getNombre(), re.getClub());
        return resultado;
    }

}
