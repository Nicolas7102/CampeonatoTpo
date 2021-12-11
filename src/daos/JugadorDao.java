package daos;
import org.hibernate.Session;

import entities.*;
import hibernate.HibernateUtil;
import modelo.*;

public class JugadorDao {

    private static JugadorDao instance;

    private JugadorDao() {}

    public static JugadorDao getInstance() {
        if(instance == null)
            instance = new JugadorDao();
        return instance;
    }

    public void save(Jugador jugador) {
        JugadorEntity aux = toEntity(jugador);
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(aux);
        s.getTransaction().commit();
        s.close();
    }

    JugadorEntity toEntity(Jugador jugador){
        JugadorEntity je = new JugadorEntity();
        je.setTipoDocumento(jugador.getTipoDocumento());
        je.setDocumento(jugador.getDocumento());
        je.setNombre(jugador.getNombre());
        je.setApellido(jugador.getApellido());
        je.setClub(ClubDao.getInstance().getClubEntityById(jugador.getClub().getIdClub()));
        je.setFechaNacimiento(jugador.getFechaNacimiento());
        je.setCategoria(jugador.getCategoria());
        return je;
    }
    
    public JugadorEntity getJugadorEntityById(int id) {
    	Session s = HibernateUtil.getSessionFactory().openSession();
    	JugadorEntity aux = (JugadorEntity) s.createQuery("from JugadorEntity je where je.idJugador = " + id).uniqueResult();
    	return aux;
    }
    
}
