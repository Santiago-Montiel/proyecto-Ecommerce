package co.com.ecommerce.daos;

import javax.persistence.EntityManager;

import co.com.ecommerce.entities.Venta;
import co.com.ecommerce.utils.Conexion;

public class ventaDAO {
EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Venta venta) {
		entity.getTransaction().begin();
		entity.persist(venta); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Venta venta) {
		entity.getTransaction().begin();
		entity.merge(venta);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Venta buscar(Integer id) {
		Venta v = new Venta();
		v = entity.find(Venta.class, id);
		
		return v;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		Venta v = new Venta();
		v = entity.find(Venta.class, v);
		entity.getTransaction().begin();
		entity.remove(v);
		entity.getTransaction().commit();
	}
}
