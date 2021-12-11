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
@Table(name="representantes")
public class ResponsableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRepresentante")
    private Integer legajo;
	private String documento;
	private String nombre;
    @ManyToOne
    @JoinColumn(name="idClub", referencedColumnName = "idClub")
	private ClubEntity club;

    public ResponsableEntity() {}

    public ResponsableEntity(String documento, String nombre, ClubEntity club) {
        this.documento = documento;
        this.nombre = nombre;
        this.club = club;
    }

    public Integer getLegajo() {
        return this.legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
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

    public ClubEntity getClub() {
        return this.club;
    }

    public void setClub(ClubEntity club) {
        this.club = club;
    }
    
}