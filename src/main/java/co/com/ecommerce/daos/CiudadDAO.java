package co.com.ecommerce.daos;

import javax.persistence.EntityManager;

import co.com.ecommerce.entities.Ciudad;
import co.com.ecommerce.utils.Conexion;

public class CiudadDAO {

EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Ciudad ciudad) {
		entity.getTransaction().begin(); 
		entity.persist(ciudad); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Ciudad ciudad) {
		entity.getTransaction().begin();
		entity.merge(ciudad);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Ciudad buscar(Integer id) {
		Ciudad c = new Ciudad();
		c = entity.find(Ciudad.class, id);
		
		return c;
	}
	
	//eliminar
	public void eliminar(Integer id) {
		Ciudad c = new Ciudad();
		c = entity.find(Ciudad.class, c);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}
	
}
