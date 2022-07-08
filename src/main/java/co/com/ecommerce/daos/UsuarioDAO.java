package co.com.ecommerce.daos;

import javax.persistence.EntityManager;

import co.com.ecommerce.entities.Usuario;
import co.com.ecommerce.utils.Conexion;

public class UsuarioDAO {
	
EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.persist(usuario); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.merge(usuario);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Usuario buscar(Integer id) {
		Usuario u = new Usuario();
		u = entity.find(Usuario.class, id);
		
		return u;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		Usuario u = new Usuario();
		u = entity.find(Usuario.class, u);
		entity.getTransaction().begin();
		entity.remove(u);
		entity.getTransaction().commit();
	}
	
}
