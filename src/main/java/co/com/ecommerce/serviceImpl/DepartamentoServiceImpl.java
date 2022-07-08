package co.com.ecommerce.serviceImpl;

import java.util.List;

import javax.inject.Inject;

import co.com.ecommerce.daos.DepartamentoDAO;
import co.com.ecommerce.entities.Departamento;
import co.com.ecommerce.entities.Pais;
import co.com.ecommerce.services.DepartamentoService;

public class DepartamentoServiceImpl implements DepartamentoService{


		@Inject
		
		Departamento dp;
		private DepartamentoDAO departamentoDao;
		DepartamentoDAO dp = new DepartamentoDAO();

		public static void agregarDepartamento(Departamento departamento) {
			
			
		}

		public void eliminarDepartamento(int idDepartamento, Pais idPais) {
			
			
		}

		public List<Departamento> listarDepartamentos() {
			
			return null;
		}
		
		@Override
		public static List<Departamento> buscarDepartamentoPorPais(int idPais) {
			Departamento d = dp.consultarCiudad(idPais);
			return d;
		}
		
}
