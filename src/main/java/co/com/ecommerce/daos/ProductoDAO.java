package co.com.ecommerce.daos;

import javax.persistence.EntityManager;

import co.com.ecommerce.entities.Producto;
import co.com.ecommerce.utils.Conexion;

public class ProductoDAO {

EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Producto producto) {
		entity.getTransaction().begin();
		entity.persist(producto); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Producto producto) {
		entity.getTransaction().begin();
		entity.merge(producto);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Producto buscar(Integer id) {
		Producto p = new Producto();
		p = entity.find(Producto.class, id);
		
		return p;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		Producto p = new Producto();
		p = entity.find(Producto.class, p);
		entity.getTransaction().begin();
		entity.remove(p);
		entity.getTransaction().commit();
	}
	
}
