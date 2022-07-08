package co.com.ecommerce.daos;

import javax.persistence.EntityManager;

import co.com.ecommerce.entities.Empresa;
import co.com.ecommerce.utils.Conexion;

public class EmpresaDAO {

EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Empresa empresa) {
		entity.getTransaction().begin();
		entity.persist(empresa); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Empresa empresa) {
		entity.getTransaction().begin();
		entity.merge(empresa);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Empresa buscar(Integer id) {
		Empresa e = new Empresa();
		e = entity.find(Empresa.class, id);
		
		return e;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		Empresa e = new Empresa();
		e = entity.find(Empresa.class, e);
		entity.getTransaction().begin();
		entity.remove(e);
		entity.getTransaction().commit();
	}
	
}
