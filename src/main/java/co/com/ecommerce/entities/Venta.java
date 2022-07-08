package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "Venta" database table.
 * 
 */
@Entity
@Table(name="\"Venta\"")
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idVenta\"")
	private Integer idVenta;

	@Column(name="\"correoEnvio\"")
	private String correoEnvio;

	@Column(name="\"direccionEnvio\"")
	private String direccionEnvio;

	@Column(name="\"estadoDeVenta\"")
	private Integer estadoDeVenta;

	@Column(name="\"estadoPedido\"")
	private Integer estadoPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaPedido\"")
	private Date fechaPedido;

	@Column(name="\"fk_idCiudad\"")
	private Integer fk_idCiudad;

	@Column(name="\"fk_idFactura\"")
	private Integer fk_idFactura;

	@Column(name="\"fk_idMetodoPago\"")
	private Integer fk_idMetodoPago;

	@Column(name="\"fk_idUsuario\"")
	private Integer fk_idUsuario;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="venta")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumns({
		})
	private Ciudad ciudad;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumns({
		})
	private Factura factura;

	//bi-directional many-to-one association to MetodoPago
	@ManyToOne
	@JoinColumns({
		})
	private MetodoPago metodoPago;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumns({
		})
	private Usuario usuario;

	public Venta() {
	}

	public Integer getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public String getCorreoEnvio() {
		return this.correoEnvio;
	}

	public void setCorreoEnvio(String correoEnvio) {
		this.correoEnvio = correoEnvio;
	}

	public String getDireccionEnvio() {
		return this.direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public Integer getEstadoDeVenta() {
		return this.estadoDeVenta;
	}

	public void setEstadoDeVenta(Integer estadoDeVenta) {
		this.estadoDeVenta = estadoDeVenta;
	}

	public Integer getEstadoPedido() {
		return this.estadoPedido;
	}

	public void setEstadoPedido(Integer estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Integer getFk_idCiudad() {
		return this.fk_idCiudad;
	}

	public void setFk_idCiudad(Integer fk_idCiudad) {
		this.fk_idCiudad = fk_idCiudad;
	}

	public Integer getFk_idFactura() {
		return this.fk_idFactura;
	}

	public void setFk_idFactura(Integer fk_idFactura) {
		this.fk_idFactura = fk_idFactura;
	}

	public Integer getFk_idMetodoPago() {
		return this.fk_idMetodoPago;
	}

	public void setFk_idMetodoPago(Integer fk_idMetodoPago) {
		this.fk_idMetodoPago = fk_idMetodoPago;
	}

	public Integer getFk_idUsuario() {
		return this.fk_idUsuario;
	}

	public void setFk_idUsuario(Integer fk_idUsuario) {
		this.fk_idUsuario = fk_idUsuario;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setVenta(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setVenta(null);

		return factura;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public MetodoPago getMetodoPago() {
		return this.metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}