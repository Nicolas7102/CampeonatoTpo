package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="listaJugadoresPartido")
public class MiembroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLista;
    @ManyToOne
    @JoinColumn(name="idClub")
	private ClubEntity club;
    @ManyToOne
    @JoinColumn(name="idPartido")
	private PartidoEntity partido;
    @OneToOne
    @JoinColumn(name="idJugador")
	private JugadorEntity jugador;
	private Integer ingreso;
	private Integer egreso;


    public MiembroEntity() {} //A salva le falta constructor vacio


    public MiembroEntity(Integer idLista, ClubEntity club, PartidoEntity partido, JugadorEntity jugador, Integer ingreso, Integer egreso) {
        this.idLista = idLista;
        this.club = club;
        this.partido = partido;
        this.jugador = jugador;
        this.ingreso = ingreso;
        this.egreso = egreso;
    }


    public MiembroEntity(ClubEntity clubEntity, PartidoEntity partido2, JugadorEntity jugador2) {
    }


    public Integer getIdLista() {
        return this.idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public ClubEntity getClub() {
        return this.club;
    }

    public void setClub(ClubEntity club) {
        this.club = club;
    }

    public PartidoEntity getPartido() {
        return this.partido;
    }

    public void setPartido(PartidoEntity partido) {
        this.partido = partido;
    }

    public JugadorEntity getJugador() {
        return this.jugador;
    }

    public void setJugador(JugadorEntity jugador) {
        this.jugador = jugador;
    }

    public Integer getIngreso() {
        return this.ingreso;
    }

    public void setIngreso(Integer ingreso) {
        this.ingreso = ingreso;
    }

    public Integer getEgreso() {
        return this.egreso;
    }

    public void setEgreso(Integer egreso) {
        this.egreso = egreso;
    }
    
    
}
