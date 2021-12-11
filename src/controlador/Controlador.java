package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import daos.CampeonatoDao;
import daos.ClubDao;
import entities.CampeonatoEntity;
import entities.ClubEntity;
import modelo.*;

public class Controlador {

	public Controlador() {}

	private static Controlador instance;

	public static Controlador getInstance(){
		if(instance==null)
			instance = new Controlador();
		return instance;
	}
	
	public void crearClub(Integer idClub, String nombre, String direccion) {
		Club club = new Club(idClub, nombre, direccion);
		club.save();
	}

	public void modificarClub(Integer idClub, String nombre, String direccion) { 
		try {  
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433", "login1", "123456");
	
			PreparedStatement st = connection.prepareStatement("UPDATE clubes set nombre='" + nombre + "' WHERE idClub ='" + idClub + "' UPDATE clubes set direccion='" + direccion + "' WHERE idClub ='" + idClub + "'");
			st.executeUpdate(); 
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void eliminarClub(Integer idClub) {
		try {  
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433", "login1", "123456");
	
			PreparedStatement st = connection.prepareStatement("DELETE FROM clubes WHERE idClub ='" + idClub + "'");
			st.executeUpdate(); 
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void eliminarClub2(Club club) {
		
	}
	
	public void crearJugador(String tipoDocumento, String documento, String nombre, String apellido, Club club, java.sql.Date fechaNacimiento, int categoria) {
		Jugador jugador = new Jugador(tipoDocumento, documento, nombre, apellido, club, fechaNacimiento, categoria);
		jugador.save();
	}

	public void eliminarJugador(int idJugador) {
		try {  
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433", "login1", "123456");
	
			PreparedStatement st = connection.prepareStatement("DELETE FROM jugadores WHERE idjugador ='" + idJugador + "'");
			st.executeUpdate(); 
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void eliminarJugadoresDesdeClub(int idClub) {
		try {  
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433", "login1", "123456");
	
			PreparedStatement st = connection.prepareStatement("DELETE FROM jugadores WHERE idclub ='" + idClub + "'");
			st.executeUpdate(); 
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void modificarJugador(int idJugador, String tipoDocumento, String nroDoc, String nombre, String apellido, int idClub, Date fecNac, int categoria) {
		try {  
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433", "login1", "123456");
	
			PreparedStatement st = connection.prepareStatement("UPDATE jugadores set tipoDocumento='" + tipoDocumento + "' WHERE idJugador ='" + idJugador + "' UPDATE jugadores set numeroDocumento='" + nroDoc + "' WHERE idJugador ='" + idJugador + "' UPDATE jugadores set nombre='" + nombre + "' WHERE idJugador ='" + idJugador + "' UPDATE jugadores set apellido='" + apellido + "' WHERE idJugador ='" + idJugador + "' UPDATE jugadores set idClub='" + idClub + "' WHERE idJugador ='" + idJugador + "' UPDATE jugadores set fechaNac='" + fecNac + "' WHERE idJugador ='" + idJugador + "' UPDATE jugadores set categoria='" + categoria + "' WHERE idJugador ='" + idJugador + "'");
			st.executeUpdate(); 
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void crearRepresentante(String documento, String nombre, Club club) {
		Responsable responsable = new Responsable(documento, nombre, club);
		responsable.save();
	}

	public void eliminarRepresentante(int idRepresentante){
		try {  
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433", "login1", "123456");
	
			PreparedStatement st = connection.prepareStatement("DELETE FROM representantes WHERE idRepresentante ='" + idRepresentante + "'");
			st.executeUpdate(); 
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void modificarRepresentante(int idRepresentante, String nombre, String documento, int idClub){
		try {  
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433", "login1", "123456");
	
			PreparedStatement st = connection.prepareStatement("UPDATE representantes set nombre='" + nombre + "' WHERE idrepresentante ='" + idRepresentante + "' UPDATE representantes set documento='" + documento + "' WHERE idrepresentante ='" + idRepresentante + "' UPDATE representantes set idclub='" + idClub + "' WHERE idrepresentante ='" + idRepresentante + "'");
			st.executeUpdate(); 
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void crearCampeonato(String descripcion, Date fechaInicio, Date fechafin, String estado) {
		Campeonato campeonato = new Campeonato(descripcion, fechaInicio, fechafin, estado);
		campeonato.save();
	}

	public void modificarCampeonato(int idCampeonato, String descripcion, Date fechaInicio, Date fechaFin, String estado) {
		try {  
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433", "login1", "123456");
	
			PreparedStatement st = connection.prepareStatement("UPDATE campeonatos set descripcion='" + descripcion + "' WHERE idCampeonato ='" + idCampeonato + "' UPDATE campeonatos set fechaInicio='" + fechaInicio + "' WHERE idCampeonato ='" + idCampeonato + "' UPDATE campeonatos set fechaFin='" + fechaFin + "' WHERE idCampeonato ='" + idCampeonato + "' UPDATE campeonatos SET estado='" + estado + "'");
			st.executeUpdate(); 
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void inscribirClub(int idClub, int idCampeonato) {
		ClubEntity club = ClubDao.getInstance().getClubEntityById(idClub);
		CampeonatoEntity ca = CampeonatoDao.getInstance().getCampeonatoEntityById(idCampeonato);
		ca.inscribirClub(club);
	}
	
	public void habilitarJugador(int idJugador, int idClub, int idCampeonato) {	}
	
	public Integer crearListaJugadores(Club club, Partido partido) { return null;}	
	
	public void agregarJugadoresEnLista() {}
}