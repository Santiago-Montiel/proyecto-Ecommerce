package co.com.ecommerce.daos;

import javax.persistence.EntityManager;

import co.com.ecommerce.entities.MetodoPago;
import co.com.ecommerce.utils.Conexion;

public class MetodoDePagoDAO {
EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(MetodoPago metodo) {
		entity.getTransaction().begin();
		entity.persist(metodo); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(MetodoPago metodo) {
		entity.getTransaction().begin();
		entity.merge(metodo);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public MetodoPago buscar(Integer id) {
		MetodoPago m = new MetodoPago();
		m = entity.find(MetodoPago.class, id);
		
		return m;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		MetodoPago m = new MetodoPago();
		m = entity.find(MetodoPago.class, m);
		entity.getTransaction().begin();
		entity.remove(m);
		entity.getTransaction().commit();
	}
}
