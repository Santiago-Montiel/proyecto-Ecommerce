package co.com.ecommerce.daos;

import javax.persistence.EntityManager;

import co.com.ecommerce.entities.Factura;
import co.com.ecommerce.utils.Conexion;

public class FacturaDAO {

EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Factura factura) {
		entity.getTransaction().begin();
		entity.persist(factura); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Factura factura) {
		entity.getTransaction().begin();
		entity.merge(factura);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Factura buscar(Integer id) {
		Factura f = new Factura();
		f = entity.find(Factura.class, id);
		
		return f;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		Factura f = new Factura();
		f = entity.find(Factura.class, f);
		entity.getTransaction().begin();
		entity.remove(f);
		entity.getTransaction().commit();
	}
	
}
