package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "Producto" database table.
 * 
 */
@Entity
@Table(name="\"Producto\"", schema = "Ecommerce")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idProducto\"")
	private Integer idProducto;

	@Column(name="\"cantidadMinima\"")
	private Integer cantidadMinima;

	@Column(name="\"cantidadUnidades\"")
	private Integer cantidadUnidades;

	private String caracteristicas;

	private double descuento;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaCreacion\"")
	private Date fechaCreacion;

	@Column(name="\"fk_idAdministrador\"")
	private Integer fk_idAdministrador;

	@Column(name="\"fk_idCategoria\"")
	private Integer fk_idCategoria;

	@Column(name="\"fk_idMarca\"")
	private Integer fk_idMarca;

	private Object imagen;

	private double iva;

	private String nombre;

	private double peso;

	@Column(name="\"unidadesVendidas\"")
	private Integer unidadesVendidas;

	private double valor;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="producto")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Administrador
	@ManyToOne
	@JoinColumns({
		})
	private Administrador administrador;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumns({
		})
	private Categoria categoria;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumns({
		})
	private Marca marca;

	public Producto() {
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidadMinima() {
		return this.cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public Integer getCantidadUnidades() {
		return this.cantidadUnidades;
	}

	public void setCantidadUnidades(Integer cantidadUnidades) {
		this.cantidadUnidades = cantidadUnidades;
	}

	public String getCaracteristicas() {
		return this.caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public double getDescuento() {
		return this.descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getFk_idAdministrador() {
		return this.fk_idAdministrador;
	}

	public void setFk_idAdministrador(Integer fk_idAdministrador) {
		this.fk_idAdministrador = fk_idAdministrador;
	}

	public Integer getFk_idCategoria() {
		return this.fk_idCategoria;
	}

	public void setFk_idCategoria(Integer fk_idCategoria) {
		this.fk_idCategoria = fk_idCategoria;
	}

	public Integer getFk_idMarca() {
		return this.fk_idMarca;
	}

	public void setFk_idMarca(Integer fk_idMarca) {
		this.fk_idMarca = fk_idMarca;
	}

	public Object getImagen() {
		return this.imagen;
	}

	public void setImagen(Object imagen) {
		this.imagen = imagen;
	}

	public double getIva() {
		return this.iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Integer getUnidadesVendidas() {
		return this.unidadesVendidas;
	}

	public void setUnidadesVendidas(Integer unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setProducto(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setProducto(null);

		return factura;
	}

	public Administrador getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}