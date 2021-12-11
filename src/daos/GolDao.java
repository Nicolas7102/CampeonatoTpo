package daos;

import org.hibernate.Session;

import entities.GolEntity;
import hibernate.HibernateUtil;
import modelo.Gol;

public class GolDao {

    private static GolDao instance;

    private GolDao() {}

    public static GolDao getInstance() {
        if(instance == null)
            instance = new GolDao();
        return instance;
    }
    
    public void save(Gol gol) {
		GolEntity aux = toEntity(gol);
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(aux);
		s.getTransaction().commit();
		s.close();
		
	}
	GolEntity toEntity(Gol gol) {
		GolEntity ge = new GolEntity();
		ge.setJugador(JugadorDao.getInstance().getJugadorEntityById(gol.getJugador().getIdJugador()));
		ge.setMinuto(gol.getMinuto());
		ge.setPartido(PartidoDao.getInstance().getPartidoEntityById(gol.getPartido().getIdPartido()));
		ge.setTipo(gol.getTipo());
		return ge;
	}
}
