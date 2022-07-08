package co.com.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "MetodoPago" database table.
 * 
 */
@Entity
@Table(name="\"MetodoPago\"", schema = "Ecommerce")
@NamedQuery(name="MetodoPago.findAll", query="SELECT m FROM MetodoPago m")
public class MetodoPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idMetodoPago\"")
	private Integer idMetodoPago;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="metodoPago")
	private List<Venta> ventas;

	public MetodoPago() {
	}

	public Integer getIdMetodoPago() {
		return this.idMetodoPago;
	}

	public void setIdMetodoPago(Integer idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setMetodoPago(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setMetodoPago(null);

		return venta;
	}

}