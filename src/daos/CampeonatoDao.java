package daos;

import org.hibernate.Session;

import entities.CampeonatoEntity;
import hibernate.HibernateUtil;
import modelo.Campeonato;

public class CampeonatoDao {

    private static CampeonatoDao instance;

    private CampeonatoDao() {}

    public static CampeonatoDao getInstance() {
		if(instance == null)
			instance = new CampeonatoDao();
		return instance;
	}

    public void save(Campeonato campeonato) {
		CampeonatoEntity aux = toEntity(campeonato);
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(aux);
		s.getTransaction().commit();
		s.close();
	}
	CampeonatoEntity toEntity(Campeonato campeonato) {
		CampeonatoEntity ce = new CampeonatoEntity(campeonato.getDescripcion(), campeonato.getFechaInicio(), campeonato.getFechaFin(), campeonato.getEstado());
		return ce;
	}
	
	public Campeonato getCampeonatoById(int id) {
    	Session s = HibernateUtil.getSessionFactory().openSession();
    	CampeonatoEntity aux = (CampeonatoEntity) s.createQuery("from CampeonatoEntity ce where ce.idCampeonato = " + id).uniqueResult();
    	return toModelo(aux);
	}
	
	public CampeonatoEntity getCampeonatoEntityById(int id) {
    	Session s = HibernateUtil.getSessionFactory().openSession();
    	CampeonatoEntity aux = (CampeonatoEntity) s.createQuery("from CampeonatoEntity ce where ce.idCampeonato = " + id).uniqueResult();
    	return aux;
    }
	
	Campeonato toModelo (CampeonatoEntity ce) {
		Campeonato resultado = new Campeonato(ce.getDescripcion(), ce.getFechaInicio(), ce.getFechaFin(), ce.getEstado());
    	return resultado;
    }
    
}
