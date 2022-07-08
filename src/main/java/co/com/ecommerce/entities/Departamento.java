package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Departamento" database table.
 * 
 */
@Entity
@Table(name="\"Departamento\"", schema = "Ecommerce")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idDepartamento\"")
	private Integer idDepartamento;

	@Column(name="\"Fk_idPais\"")
	private Integer fk_idPais;

	private String nombre;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="departamento")
	private List<Ciudad> ciudads;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumns({
		})
	private Pais pai;

	public Departamento() {
	}

	public Integer getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Integer getFk_idPais() {
		return this.fk_idPais;
	}

	public void setFk_idPais(Integer fk_idPais) {
		this.fk_idPais = fk_idPais;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(List<Ciudad> ciudads) {
		this.ciudads = ciudads;
	}

	public Ciudad addCiudad(Ciudad ciudad) {
		getCiudads().add(ciudad);
		ciudad.setDepartamento(this);

		return ciudad;
	}

	public Ciudad removeCiudad(Ciudad ciudad) {
		getCiudads().remove(ciudad);
		ciudad.setDepartamento(null);

		return ciudad;
	}

	public Pais getPai() {
		return this.pai;
	}

	@Override
	public String toString() {
		return "Departamento [idDepartamento=" + idDepartamento + ", fk_idPais=" + fk_idPais + ", nombre=" + nombre
				+ ", ciudads=" + ciudads + ", pai=" + pai + "]";
	}

	public void setPai(Pais pai) {
		this.pai = pai;
	}

	

}