package co.com.ecommerce.test;

import java.util.List;

import co.com.ecommerce.daos.DepartamentoDAO;
import co.com.ecommerce.entities.Departamento;

//import co.com.ecommerce.daos.AdministradorDAO;
//import co.com.ecommerce.daos.CiudadDAO;
//import co.com.ecommerce.entities.Administrador;
//import co.com.ecommerce.entities.Ciudad;
//import co.com.ecommerce.utils.Conexion;

public class Test {
	public static void main(String[] args) {
		
	/*
	Administrador a = new Administrador();
	AdministradorDAO ad = new AdministradorDAO();
	
	a.setIdentificacion(1);
	a.setNombre("santiago");
	a.setApellido("montiel");
	a.setTipoDeIdentificacion("CC");
	a.setFk_idEmpresa(1);
	a.setTelefono("3253484");
	a.setCorreo("sa@gmail.com");
	a.setDireccion("7k 86f");
	a.setCodigoPostal("??");
	a.setFk_idRol(1);
	a.setContrasena("123456789");
	a.setFechaNacimiento(null);
	
	ad.guardar(a);
	Conexion.shutdown();
	*/
	/*	
	Ciudad c = new Ciudad();
	CiudadDAO cd = new CiudadDAO();
	c.setIdCiudad(3);
	c.setNombre("cali");
	c.setFk_idDepartamento(null);
	
	cd.guardar(c);
	Conexion.shutdown();
	*/
	
	DepartamentoDAO dep = new DepartamentoDAO();
	
	List<Departamento>lista = dep.obtenerDepartamento();
	Departamento departamento = null;
	for(int i=0; i < lista.size(); i++) {
		departamento = lista.get(i);
		
		System.out.println(departamento.toString());
	}
	
		
}
}