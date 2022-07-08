package co.com.ecommerce.daos;

import javax.persistence.EntityManager;

import co.com.ecommerce.entities.Marca;
import co.com.ecommerce.utils.Conexion;

public class MarcaDAO {

EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Marca marca) {
		entity.getTransaction().begin();
		entity.persist(marca); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Marca marca) {
		entity.getTransaction().begin();
		entity.merge(marca);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Marca buscar(Integer id) {
		Marca m = new Marca();
		m = entity.find(Marca.class, id);
		
		return m;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		Marca m = new Marca();
		m = entity.find(Marca.class, m);
		entity.getTransaction().begin();
		entity.remove(m);
		entity.getTransaction().commit();
	}
	
}
