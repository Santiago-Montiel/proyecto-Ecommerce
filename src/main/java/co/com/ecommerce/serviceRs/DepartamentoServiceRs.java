package co.com.ecommerce.serviceRs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.persistence.oxm.MediaType;

import co.com.ecommerce.entities.Departamento;
import co.com.ecommerce.entities.Pais;
import co.com.ecommerce.serviceImpl.DepartamentoServiceImpl;

@Path("/Departamento")
public class DepartamentoServiceRs {
	private DepartamentoServiceImpl departamentoServiceImpl;
	
	public DepartamentoServiceRs() {
		departamentoServiceImpl = new DepartamentoServiceImpl();
	}
	
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)	
	public void agregarDepartamento(Departamento departamento) {
		DepartamentoServiceImpl.agregarDepartamento(departamento);
	}
	
	@PUT
	//@Consumes(MediaType.APPLICATION_JSON)
	public void eliminarDepartamento(int idDepartamento, Pais idPais) {
		departamentoServiceImpl.eliminarDepartamento(idDepartamento, idPais);
	}
	
	@GET
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/departamento/{idPais}")
	public List<Departamento> listarDepartamentos(){
		List<Departamento> departamentos = departamentoServiceImpl.listarDepartamentos();
		return departamentos;
	}
	
	@GET
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/departamentoPorPais/{idPais}")
	public List<Departamento> buscarDepartamentoPorPais(@PathParam("idPais")int idPais){
		List<Departamento> departamentos = DepartamentoServiceImpl.buscarDepartamentoPorPais(idPais);
		return departamentos;
	}
	
	
	
	
	
	
	
	
}
