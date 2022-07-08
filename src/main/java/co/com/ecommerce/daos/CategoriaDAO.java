package co.com.ecommerce.daos;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.Query;

import co.com.ecommerce.entities.Categoria;
import co.com.ecommerce.utils.Conexion;

public class CategoriaDAO {

EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Categoria categoria) {
		entity.getTransaction().begin(); 
		entity.persist(categoria); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Categoria categoria) {
		entity.getTransaction().begin();
		entity.merge(categoria);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Categoria buscar(Integer id) {
		Categoria c = new Categoria();
		c = entity.find(Categoria.class, id);
		
		return c;
	}
	
	//eliminar
	public void eliminar(Integer id) {
		Categoria c = new Categoria();
		c = entity.find(Categoria.class, c);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}
	/*
	//listar categorias
		public List<Categoria> listarCategoria(){
			List<Categoria> listarCategoria = new ArrayList<Categoria>();
			Query q = (Query) entity.createQuery("SELECT c FROM Categoria c");
			listarCategoria = ((javax.persistence.Query)q).getResultList();
			return listarCategoria;
			
		}
		*/
}