package daos;

import org.hibernate.Session;

import entities.FaltaEntity;
import hibernate.HibernateUtil;
import modelo.Falta;

public class FaltaDao {

    private static FaltaDao instance;

    private FaltaDao() {}

    public static FaltaDao getInstance() {
        if(instance == null)
            instance = new FaltaDao();
        return instance;
    }
    
    public void save(Falta falta ) {
		FaltaEntity aux = toEntity(falta);
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(aux);
		s.getTransaction().commit();
		s.close();
	}
	
	FaltaEntity toEntity(Falta falta) {
		FaltaEntity fe = new FaltaEntity();
		fe.setCampeonato(CampeonatoDao.getInstance().getCampeonatoEntityById(falta.getCampeonato().getIdCampeonato()));
		fe.setJugador(JugadorDao.getInstance().getJugadorEntityById(falta.getJugador().getIdJugador()));
		fe.setMinuto(falta.getMinuto());
		fe.setPartido(PartidoDao.getInstance().getPartidoEntityById(falta.getPartido().getIdPartido()));
		fe.setTipo(falta.getTipo());
		return fe;
	}
}
