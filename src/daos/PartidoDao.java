package daos;

import org.hibernate.Session;

import entities.PartidoEntity;
import hibernate.HibernateUtil;
import modelo.Partido;

public class PartidoDao {

    private static PartidoDao instance;

    private PartidoDao() {}

    public static PartidoDao getInstance() {
        if(instance == null)
            instance = new PartidoDao();
        return instance;
    }

    public void save(Partido partido ) {
		PartidoEntity aux = toEntity(partido);
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(aux);
		s.getTransaction().commit();
		s.close();
	}

    PartidoEntity toEntity(Partido partido) {
		// Le faltan parametros? PartidoEntity pe = new PartidoEntity(partido.getNroFecha(), partido.getNroZona(), partido.getCategoria(), ClubDao.getInstance().getClubEntityById(partido.getClubLocal().getIdClub()), ClubDao.getInstance().getClubEntityById(partido.getClubVisitante().getIdClub()), partido.getFechaPartido(), CampeonatoDao.getInstance().getCampeonatoEntityById(partido.getCampeonato().getIdCampeonato())));
		PartidoEntity pe = new PartidoEntity(partido.getNroFecha(), partido.getNroZona(), partido.getCategoria(), ClubDao.getInstance().getClubEntityById(partido.getClubLocal().getIdClub()), ClubDao.getInstance().getClubEntityById(partido.getClubVisitante().getIdClub()), partido.getGolesLocal(), partido.getGolesVisitante(), partido.getFechaPartido(), CampeonatoDao.getInstance().getCampeonatoEntityById(partido.getCampeonato().getIdCampeonato()), partido.getJugadoresLocales(), partido.getJugadoresVisitantes());
        return pe;
	}
    
    public PartidoEntity getPartidoEntityById(int id) {
    	Session s = HibernateUtil.getSessionFactory().openSession();
    	PartidoEntity aux = (PartidoEntity) s.createQuery("from PartidoEntity pe where pe.idPartido = " + id).uniqueResult();
    	return aux;
    }
}
