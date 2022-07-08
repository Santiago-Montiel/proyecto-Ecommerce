package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "Factura" database table.
 * 
 */
@Entity
@Table(name="\"Factura\"", schema = "Ecommerce")
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idFactura\"")
	private Integer idFactura;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaCompra\"")
	private Date fechaCompra;

	@Column(name="\"fk_idProducto\"")
	private Integer fk_idProducto;

	@Column(name="\"fk_idVenta\"")
	private Integer fk_idVenta;

	@Column(name="\"precioTotal\"")
	private double precioTotal;

	@Column(name="\"Promedio\"")
	private double promedio;

	@Column(name="\"subTotal\"")
	private double subTotal;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumns({
		})
	private Producto producto;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumns({
		})
	private Venta venta;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="factura")
	private List<Venta> ventas;

	public Factura() {
	}

	public Integer getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Integer getFk_idProducto() {
		return this.fk_idProducto;
	}

	public void setFk_idProducto(Integer fk_idProducto) {
		this.fk_idProducto = fk_idProducto;
	}

	public Integer getFk_idVenta() {
		return this.fk_idVenta;
	}

	public void setFk_idVenta(Integer fk_idVenta) {
		this.fk_idVenta = fk_idVenta;
	}

	public double getPrecioTotal() {
		return this.precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getPromedio() {
		return this.promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public double getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setFactura(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setFactura(null);

		return venta;
	}

}