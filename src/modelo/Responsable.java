package modelo;

import daos.ResponsableDao;
import entities.ClubEntity;

public class Responsable implements Comparable<Responsable>{

	private Integer legajo;
	private String documento;
	private String nombre;
	private Club club;
	
	
	public Responsable(String documento, String nombre, Club club) {
		this.legajo = null;
		this.documento = documento;
		this.nombre = nombre;
		this.club = club;
	}


	public Responsable(Integer legajo, String documento, String nombre, Club club) {
		this.legajo = legajo;
		this.documento = documento;
		this.nombre = nombre;
		this.club = club;
	}
	

    public Responsable(Integer legajo2, String documento2, String nombre2, ClubEntity club2) {
	}


	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	@Override
	public int compareTo(Responsable o) {
		return this.documento.compareTo(o.getDocumento());
	}

	public Integer getLegajo() {
		return legajo;
	}


	public void save() {
		ResponsableDao.getInstance().save(this);
	}
}
