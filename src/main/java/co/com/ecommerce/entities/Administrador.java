package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "Administrador" database table.
 * 
 */
@Entity
@Table(name="\"Administrador\"", schema = "Ecommerce")
@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer identificacion;

	private String apellido;

	@Column(name="\"codigoPostal\"")
	private String codigoPostal;

	private String contrasena;

	private String correo;

	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaNacimiento\"")
	private Date fechaNacimiento;

	@Column(name="\"fk_idEmpresa\"")
	private Integer fk_idEmpresa;

	@Column(name="\"fk_idRol\"")
	private Integer fk_idRol;

	private String nombre;

	private String telefono;

	@Column(name="\"tipoDeIdentificacion\"")
	private String tipoDeIdentificacion;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumns({
		})
	private Empresa empresa;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumns({
		})
	private Rol rol;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="administrador")
	private List<Producto> productos;

	public Administrador() {
	}

	public Integer getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getFk_idEmpresa() {
		return this.fk_idEmpresa;
	}

	public void setFk_idEmpresa(Integer fk_idEmpresa) {
		this.fk_idEmpresa = fk_idEmpresa;
	}

	public Integer getFk_idRol() {
		return this.fk_idRol;
	}

	public void setFk_idRol(Integer fk_idRol) {
		this.fk_idRol = fk_idRol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoDeIdentificacion() {
		return this.tipoDeIdentificacion;
	}

	public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
		this.tipoDeIdentificacion = tipoDeIdentificacion;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setAdministrador(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setAdministrador(null);

		return producto;
	}

}