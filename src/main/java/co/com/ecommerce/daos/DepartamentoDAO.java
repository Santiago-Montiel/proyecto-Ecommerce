package co.com.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.ecommerce.entities.Departamento;
import co.com.ecommerce.utils.Conexion;

public class DepartamentoDAO {

EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();
	
	//guardar 
	public void guardar(Departamento departamento) {
		entity.getTransaction().begin();
		entity.persist(departamento); 
		entity.getTransaction().commit(); 
	}
	
	//editar 
	public void editar(Departamento departamento) {
		entity.getTransaction().begin();
		entity.merge(departamento);
		entity.getTransaction().commit();
	}
	
	//buscar 
	public Departamento buscar(Integer id) {
		Departamento d = new Departamento();
		d = entity.find(Departamento.class, id);
		
		return d;
	}
	
	//eliminar 
	public void eliminar(Integer id) {
		Departamento d = new Departamento();
		d = entity.find(Departamento.class, d);
		entity.getTransaction().begin();
		entity.remove(d);
		entity.getTransaction().commit();
	}
	
	
	public List<Departamento> obtenerDepartamento(){
		List<Departamento> listaDepartamento = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT d FROM Departamento d");
		listaDepartamento = consulta.getResultList();
		return listaDepartamento;
		
	}
	
	public List<Departamento> BuscarDepartamentoPorPais(int idPais){
		List<Departamento> listaDepartamentoPais = new ArrayList<>();
		Query consulta = entity.createQuery("SELECT pa.nombre, dp.nombre FROM ecommerce.Pais "
				+ "as pa inner join ecommerce.\"Departamento\" "
				+ "as dp on pa.idPais = dp.Fk_idPais"
				+ " where pa.nombre = " +idPais+ ";");
		
		listaDepartamentoPais = consulta.getResultList();
		return listaDepartamentoPais;
		
	}
	
}
