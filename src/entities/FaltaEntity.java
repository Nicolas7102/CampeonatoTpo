package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="faltas")
public class FaltaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFalta;
    @ManyToOne
    @JoinColumn(name="idJugador")
	private JugadorEntity jugador;
    @ManyToOne
    @JoinColumn(name="idPartido")
	private PartidoEntity partido;
    @ManyToOne
    @JoinColumn(name="idCampeonato")
	private CampeonatoEntity campeonato;
	private int minuto;
	private String tipo;

    public FaltaEntity() {}


    public FaltaEntity(JugadorEntity jugador, PartidoEntity partido, CampeonatoEntity campeonato, int minuto, String tipo) {
        this.jugador = jugador;
        this.partido = partido;
        this.campeonato = campeonato;
        this.minuto = minuto;
        this.tipo = tipo;
    }


    public Integer getIdFalta() {
        return this.idFalta;
    }

    public void setIdFalta(Integer idFalta) {
        this.idFalta = idFalta;
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

    public CampeonatoEntity getCampeonato() {
        return this.campeonato;
    }

    public void setCampeonato(CampeonatoEntity campeonato) {
        this.campeonato = campeonato;
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
    

}
