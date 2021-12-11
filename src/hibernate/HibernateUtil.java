package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.*;


public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil(){
		try
		{
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(CampeonatoEntity.class);
			config.addAnnotatedClass(ClubEntity.class);
			config.addAnnotatedClass(FaltaEntity.class);
			config.addAnnotatedClass(GolEntity.class);
			config.addAnnotatedClass(JugadorEntity.class);
			config.addAnnotatedClass(MiembroEntity.class);
			config.addAnnotatedClass(PartidoEntity.class);
			config.addAnnotatedClass(ResponsableEntity.class);
			sessionFactory = config.buildSessionFactory();
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
			new HibernateUtil();
		return sessionFactory;
	}
}
