package co.com.ecommerce.daos;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.Query;

import co.com.ecommerce.entities.Administrador;
import co.com.ecommerce.utils.Conexion;

public class AdministradorDAO {
EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Administrador administrador) {
		entity.getTransaction().begin(); // trae la transaccion y la empieza
		entity.persist(administrador); //persis es el insert en la base de datos
		entity.getTransaction().commit(); //para guardarlo en la base de datos
	}
	
	//editar 
	public void editar(Administrador administrador) {
		entity.getTransaction().begin();
		entity.merge(administrador);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Administrador buscar(Integer id) {
		Administrador a = new Administrador();
		a = entity.find(Administrador.class, id);
		
		return a;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		Administrador a = new Administrador();
		a = entity.find(Administrador.class, a);
		entity.getTransaction().begin();
		entity.remove(a);
		entity.getTransaction().commit();
	}
	
	//listar administradores
	/*
	public List<Administrador> listarAdministradores(){
		List<Administrador> listarAdministradores = new ArrayList<Administrador>();
		Query q = (Query) entity.createQuery("SELECT a FROM Administrador a");
		listarAdministradores = ((javax.persistence.Query)q).getResultList();
		return listarAdministradores;
		
	}
	*/
}
