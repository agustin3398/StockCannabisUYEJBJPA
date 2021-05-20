package controlador;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import DAO.DAOEmpresaFarmacia;
import entidades.EmpresaFarmacia;

@Stateless
@LocalBean
public class ControladorEmpresaFarmacia implements ControladorEmpresaFarmaciaRemote {

	@EJB
	private DAOEmpresaFarmacia daoEmpresaFarmacia;

	public ControladorEmpresaFarmacia() {
	}

	@Override
	public void crearNuevaEmpresaFarmacia(EmpresaFarmacia empresaFarmacia) {
		try {
			daoEmpresaFarmacia.crearEmpresaFarmacia(empresaFarmacia);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Hubo un error al crear crearNuevaEmpresaFarmacia");
			System.out.println("Clase: ControladorEmpresaFarmacia");
			System.out.println("Metodo: crearNuevaEmpresaFarmacia");
			System.out.println("****************************");

		}
	}

	@Override
	public List<EmpresaFarmacia> obtenerTodasEmpresaFarmacia() {
		List<EmpresaFarmacia> empreFarm = null;

		try {
			empreFarm = daoEmpresaFarmacia.obtenerEmpresasFarmacias();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Hubo un error al crear obtenerTodasEmpresaFarmacia");
			System.out.println("Clase: ControladorEmpresaFarmacia");
			System.out.println("Metodo: obtenerTodasEmpresaFarmacia");
			System.out.println("****************************");
		}
		return empreFarm;
	}
}
