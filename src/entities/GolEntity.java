package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
 @Table(name="goles")
public class GolEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idGol;
    @ManyToOne
    @JoinColumn(name="idJugador")
	private JugadorEntity jugador;
    @ManyToOne
    @JoinColumn(name="idPartido")
	private PartidoEntity partido;
	private int minuto;
    @Column(name="sentido")
	private String tipo;


    public GolEntity() {}


    public GolEntity(Integer idGol, JugadorEntity jugador, PartidoEntity partido, int minuto, String tipo) {
        this.idGol = idGol;
        this.jugador = jugador;
        this.partido = partido;
        this.minuto = minuto;
        this.tipo = tipo;
    }


    public Integer getIdGol() {
        return this.idGol;
    }

    public void setIdGol(Integer idGol) {
        this.idGol = idGol;
    }

    public JugadorEntity getJugador() {
        return this.jugador;
    }

    public void setJugador(JugadorEntity jugador) {
        this.jugador = jugador;
    }

    public PartidoEntity getPartido() {
        return this.partido;
    }

    public void setPartido(PartidoEntity partido) {
        this.partido = partido;
    }

    public int getMinuto() {
        return this.minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public void setJugadorEnt(JugadorEntity jugadorEntityById) {
    }
    

}
