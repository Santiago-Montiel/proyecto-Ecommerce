package co.com.ecommerce.daos;

import javax.persistence.EntityManager;

import co.com.ecommerce.entities.Pais;
import co.com.ecommerce.utils.Conexion;

public class PaisDAO {
EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Pais pais) {
		entity.getTransaction().begin();
		entity.persist(pais); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Pais pais) {
		entity.getTransaction().begin();
		entity.merge(pais);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Pais buscar(Integer id) {
		Pais p = new Pais();
		p = entity.find(Pais.class, id);
		
		return p;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		Pais p = new Pais();
		p = entity.find(Pais.class, p);
		entity.getTransaction().begin();
		entity.remove(p);
		entity.getTransaction().commit();
	}
	
}
