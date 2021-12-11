package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clubes")
public class ClubEntity {

    @Id
    private Integer idClub;
	private String nombre;
	private String direccion;
    @OneToMany
    @JoinTable(name="representantes")
    private List<ResponsableEntity> responsables;
    @OneToMany
    @JoinTable(name="jugadores")
	private List<JugadorEntity> jugadores;
    @ManyToMany
    @JoinTable(name="clubesCampeonato", joinColumns = @JoinColumn(name="idClub"), inverseJoinColumns = @JoinColumn(name="idCampeonato"))
	private List<CampeonatoEntity> participaciones;


    public ClubEntity() {}


    public ClubEntity(Integer idClub, String nombre, String direccion) {
		this.idClub = idClub;
		this.nombre = nombre;
		this.direccion = direccion;
        responsables = new ArrayList<ResponsableEntity>();
        jugadores = new ArrayList<JugadorEntity>();
        participaciones = new ArrayList<CampeonatoEntity>();
	}


    public Integer getIdClub() {
        return this.idClub;
    }

    public void setIdClub(Integer idClub) {
        this.idClub = idClub;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<ResponsableEntity> getResponsables() {
        return this.responsables;
    }

    public void setResponsables(List<ResponsableEntity> responsables) {
        this.responsables = responsables;
    }

    public List<JugadorEntity> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores(List<JugadorEntity> jugadores) {
        this.jugadores = jugadores;
    }

    public List<CampeonatoEntity> getParticipaciones() {
        return this.participaciones;
    }

    public void setParticipaciones(List<CampeonatoEntity> participaciones) {
        this.participaciones = participaciones;
    }

    public boolean participa(CampeonatoEntity campeonato) {
		return participaciones.contains(campeonato);
	}
	
	public void participar(CampeonatoEntity campeonato) {
		participaciones.add(campeonato);
	}
	
	public void agregarJugadoresToListaLocal(JugadorEntity jugador, PartidoEntity partido) {
		partido.agregarJugadoresLocales(new MiembroEntity(this, partido, jugador));
	}
	
	public void agregarJugadoresToListaVisitante(JugadorEntity jugador, PartidoEntity partido) {
		partido.agregarJugadoresVisitantes(new MiembroEntity(this, partido, jugador)); //Creé constructor con estos parametros
	}
    
    public void asignarResponsable(ResponsableEntity responsable) {
		responsables.add(responsable);
	}
	
	public void agregarJugador(JugadorEntity jugador) {
		jugadores.add(jugador);
	}

}
