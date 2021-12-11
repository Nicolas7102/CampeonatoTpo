package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import daos.JugadorDao;

public class Jugador implements Comparable<Jugador>{

	private Integer idJugador;
	private String tipoDocumento;
	private String documento;
	private String nombre;
	private String apellido;
	private Club club;
	private Date fechaNacimiento;
	private int categoria;
	private List<Gol> goles;
	private List<Falta> faltas;
	
	public Jugador(String tipoDocumento, String documento, String nombre, String apellido, Club club, Date fechaNacimiento, int categoria) {
		this.idJugador = null;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.club = club;
		this.fechaNacimiento = fechaNacimiento;
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		int auxCategoria = Integer.parseInt(getYearFormat.format(this.fechaNacimiento));
        if(auxCategoria > 1999)
        	this.categoria = auxCategoria - 1900;
        else
        	this.categoria = auxCategoria - 2000;
        this.goles = new ArrayList<Gol>();
        this.faltas = new ArrayList<Falta>();
	}

	public Integer getIdJugador() {
		return idJugador;
	}

public String getTipoDocumento() {
	return tipoDocumento;
}	

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getCategoria() {
		return categoria;
	}

	public List<Gol> getGoles() {
		return goles;
	}

	public void agregarGol(Gol gol) {
		goles.add(gol);
	}
	
	public List<Falta> getFaltas() {
		return faltas;
	}
	
	public void agregarFalta(Falta falta) {
		faltas.add(falta);
	}

	
	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	@Override
	public int compareTo(Jugador o) {
		return this.documento.compareTo(o.getDocumento());
	}

	public void save() {
		JugadorDao.getInstance().save(this);
	}
	
}
