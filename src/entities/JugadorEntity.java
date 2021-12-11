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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="jugadores")
public class JugadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJugador;
    private String tipoDocumento;
    @Column(name="numeroDocumento")
	private String documento;
	private String nombre;
    private String apellido;
    @ManyToOne
    @JoinColumn(name="idClub")
	private ClubEntity club;
    @Column(name="fechaNac")
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	private int categoria;
    @OneToMany
    @JoinTable(name="goles")
	private List<GolEntity> goles;
    @OneToMany
    @JoinTable(name="faltas")
	private List<FaltaEntity> faltas;


    public JugadorEntity() {}


    public JugadorEntity(String tipoDocumento, String documento, String nombre, String apellido, ClubEntity club, Date fechaNacimiento, int categoria, List<GolEntity> goles, List<FaltaEntity> faltas) {
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.club = club;
        this.fechaNacimiento = fechaNacimiento;
        this.categoria = categoria;
        this.goles = goles;
        this.faltas = faltas;
    }


    public Integer getIdJugador() {
        return this.idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ClubEntity getClub() {
        return this.club;
    }

    public void setClub(ClubEntity club) {
        this.club = club;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCategoria() {
        return this.categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public List<GolEntity> getGoles() {
        return this.goles;
    }

    public void setGoles(List<GolEntity> goles) {
        this.goles = goles;
    }

    public List<FaltaEntity> getFaltas() {
        return this.faltas;
    }

    public void setFaltas(List<FaltaEntity> faltas) {
        this.faltas = faltas;
    }
    


    
}
