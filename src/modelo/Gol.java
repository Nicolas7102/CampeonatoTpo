package modelo;

public class Gol {

	private Integer idGol;
	private Jugador jugador;
	private Partido partido;
	private int minuto;
	private String tipo;
		
	public Gol(Jugador jugador, Partido partido, int minuto, String tipo) {
		this.setIdGol(null);
		this.jugador = jugador;
		this.partido = partido;
		this.minuto = minuto;
		this.tipo = tipo;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	public Partido getPartido() {
		return partido;
	}
	public int getMinuto() {
		return minuto;
	}
	public String getTipo() {
		return tipo;
	}

	public Integer getIdGol() {
		return idGol;
	}

	public void setIdGol(Integer idGol) {
		this.idGol = idGol;
	}

}
