package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.Miembro;

@Entity
@Table(name="partidos")
public class PartidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPartido;
	private int nroFecha;
	private int nroZona;
	private int categoria;
    @OneToOne
    @JoinColumn(name="idClubLocal")
	private ClubEntity clubLocal;
    @OneToOne
	@JoinColumn(name="idClubVisitante")
	private ClubEntity clubVisitante;
	private Integer golesLocal;
	private Integer golesVisitante;
	private Date fechaPartido;
    @Column(name="validadoLocal")
	private boolean convalidaLocal;
    @Column(name="validadoVisitante")
	private boolean convalidaVisitante;
    @OneToOne
	@JoinColumn(name="idCampeonato")
	private CampeonatoEntity campeonato;
    @OneToMany
	@JoinTable(name="listaJugadoresPartido")
	private List<MiembroEntity> jugadoresLocales;
    @OneToMany
	@JoinTable(name="listaJugadoresPartido")
	private List<MiembroEntity> jugadoresVisitantes;


    public PartidoEntity() {}


    public PartidoEntity(int nroFecha, int nroZona, int categoria, ClubEntity clubLocal, ClubEntity clubVisitante, Integer golesLocal, Integer golesVisitante, Date fechaPartido, boolean convalidaLocal, boolean convalidaVisitante, CampeonatoEntity campeonato, List<MiembroEntity> jugadoresLocales, List<MiembroEntity> jugadoresVisitantes) {
        this.nroFecha = nroFecha;
        this.nroZona = nroZona;
        this.categoria = categoria;
        this.clubLocal = clubLocal;
        this.clubVisitante = clubVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.fechaPartido = fechaPartido;
        this.convalidaLocal = convalidaLocal;
        this.convalidaVisitante = convalidaVisitante;
        this.campeonato = campeonato;
        this.jugadoresLocales = jugadoresLocales;
        this.jugadoresVisitantes = jugadoresVisitantes;
    }


    public PartidoEntity(int nroFecha2, int nroZona2, int categoria2, ClubEntity clubEntityById,
            ClubEntity clubEntityById2, Integer golesLocal2, Integer golesVisitante2, Date fechaPartido2,
            CampeonatoEntity campeonatoEntityById, List<Miembro> jugadoresLocales2,
            List<Miembro> jugadoresVisitantes2) {
    }


    public Integer getIdPartido() {
        return this.idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public int getNroFecha() {
        return this.nroFecha;
    }

    public void setNroFecha(int nroFecha) {
        this.nroFecha = nroFecha;
    }

    public int getNroZona() {
        return this.nroZona;
    }

    public void setNroZona(int nroZona) {
        this.nroZona = nroZona;
    }

    public int getCategoria() {
        return this.categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public ClubEntity getClubLocal() {
        return this.clubLocal;
    }

    public void setClubLocal(ClubEntity clubLocal) {
        this.clubLocal = clubLocal;
    }

    public ClubEntity getClubVisitante() {
        return this.clubVisitante;
    }

    public void setClubVisitante(ClubEntity clubVisitante) {
        this.clubVisitante = clubVisitante;
    }

    public Integer getGolesLocal() {
        return this.golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return this.golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Date getFechaPartido() {
        return this.fechaPartido;
    }

    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public boolean isConvalidaLocal() {
        return this.convalidaLocal;
    }

    public boolean getConvalidaLocal() {
        return this.convalidaLocal;
    }

    public void setConvalidaLocal(boolean convalidaLocal) {
        this.convalidaLocal = convalidaLocal;
    }

    public boolean isConvalidaVisitante() {
        return this.convalidaVisitante;
    }

    public boolean getConvalidaVisitante() {
        return this.convalidaVisitante;
    }

    public void setConvalidaVisitante(boolean convalidaVisitante) {
        this.convalidaVisitante = convalidaVisitante;
    }

    public CampeonatoEntity getCampeonato() {
        return this.campeonato;
    }

    public void setCampeonato(CampeonatoEntity campeonato) {
        this.campeonato = campeonato;
    }

    public List<MiembroEntity> getJugadoresLocales() {
        return this.jugadoresLocales;
    }

    public void setJugadoresLocales(List<MiembroEntity> jugadoresLocales) {
        this.jugadoresLocales = jugadoresLocales;
    }

    public List<MiembroEntity> getJugadoresVisitantes() {
        return this.jugadoresVisitantes;
    }

    public void setJugadoresVisitantes(List<MiembroEntity> jugadoresVisitantes) {
        this.jugadoresVisitantes = jugadoresVisitantes;
    }

    public void agregarJugadoresLocales(MiembroEntity miembro) {
		this.jugadoresLocales.add(miembro);
	}

	public void agregarJugadoresVisitantes(MiembroEntity miembro) {
		this.jugadoresVisitantes.add(miembro);
	}
}
