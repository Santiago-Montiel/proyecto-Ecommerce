package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Ciudad" database table.
 * 
 */
@Entity
@Table(name="\"Ciudad\"", schema = "Ecommerce")
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idCiudad\"")
	private Integer idCiudad;

	@Column(name="\"fk_idDepartamento\"")
	private Integer fk_idDepartamento;

	private String nombre;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumns({
		})
	private Departamento departamento;

	public Ciudad() {
	}

	public Integer getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Integer getFk_idDepartamento() {
		return this.fk_idDepartamento;
	}

	public void setFk_idDepartamento(Integer fk_idDepartamento) {
		this.fk_idDepartamento = fk_idDepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}