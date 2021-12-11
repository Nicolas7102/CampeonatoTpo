package modelo;

public class Miembro {

	private Integer idLista; //arreglar -> le hice un getIdLista
	private Club club;
	private Partido partido;
	private Jugador jugador;
	private Integer ingreso;
	private Integer egreso;

	
	public Miembro(Club club, Partido partido, Jugador jugador) {
		this.club = club;
		this.partido = partido;
		this.jugador = jugador;
		this.ingreso = null;
		this.egreso = null;
	}

	public Integer idLista() {
		return idLista;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	
	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Integer getIngreso() {
		return ingreso;
	}

	public void setIngreso(Integer ingreso) {
		this.ingreso = ingreso;
	}

	public Integer getEgreso() {
		return egreso;
	}

	public void setEgreso(Integer egreso) {
		this.egreso = egreso;
	}
}


