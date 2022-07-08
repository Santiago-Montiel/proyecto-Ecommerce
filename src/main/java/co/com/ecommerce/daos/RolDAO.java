package co.com.ecommerce.daos;

import javax.persistence.EntityManager;

import co.com.ecommerce.entities.Rol;
import co.com.ecommerce.utils.Conexion;

public class RolDAO {
EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Rol rol) {
		entity.getTransaction().begin();
		entity.persist(rol); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Rol rol) {
		entity.getTransaction().begin();
		entity.merge(rol);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Rol buscar(Integer id) {
		Rol r = new Rol();
		r = entity.find(Rol.class, id);
		
		return r;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		Rol r = new Rol();
		r = entity.find(Rol.class, r);
		entity.getTransaction().begin();
		entity.remove(r);
		entity.getTransaction().commit();
	}
	
}
