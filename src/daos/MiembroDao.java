package daos;

import org.hibernate.Session;

import entities.MiembroEntity;
import hibernate.HibernateUtil;
import modelo.Miembro;

public class MiembroDao {

    private static MiembroDao instance;

    private MiembroDao() {}
    
    public static MiembroDao getInstance() {
        if(instance == null)
            instance = new MiembroDao();
        return instance;
    }

    public void save(Miembro miembro) {
		MiembroEntity aux = toEntity(miembro);
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(aux);
		s.getTransaction().commit();
		s.close();
    }

    MiembroEntity toEntity(Miembro miembro) {
		MiembroEntity me = new MiembroEntity();
		/*me.setClub(ClubDao.getInstance().getClubEntityById(miembro.getClub().getIdClub()));
        me.setEgreso(miembro.getEgreso());
        me.setIngreso(miembro.getIngreso());
        me.setEgreso(miembro.getIngreso());
        me.setJugador(JugadorDao.getInstance().getJugadorEntityById(miembro.getJugador().getIdJugador()));
        me.setPartido(PartidoDao.getInstance().getPartidoEntityById(miembro.getPartido().getIdPartido()));*/
		return me;
	}
}
