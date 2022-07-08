package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Empresa" database table.
 * 
 */
@Entity
@Table(name="\"Empresa\"", schema = "Ecommerce")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer nit;

	private String correo;

	private String direccion;

	private Object imagen;

	private String nombre;

	@Column(name="\"razonSocial\"")
	private String razonSocial;

	private String telefono;

	//bi-directional many-to-one association to Administrador
	@OneToMany(mappedBy="empresa")
	private List<Administrador> administradors;

	public Empresa() {
	}

	public Integer getNit() {
		return this.nit;
	}

	public void setNit(Integer nit) {
		this.nit = nit;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Object getImagen() {
		return this.imagen;
	}

	public void setImagen(Object imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Administrador> getAdministradors() {
		return this.administradors;
	}

	public void setAdministradors(List<Administrador> administradors) {
		this.administradors = administradors;
	}

	public Administrador addAdministrador(Administrador administrador) {
		getAdministradors().add(administrador);
		administrador.setEmpresa(this);

		return administrador;
	}

	public Administrador removeAdministrador(Administrador administrador) {
		getAdministradors().remove(administrador);
		administrador.setEmpresa(null);

		return administrador;
	}

}