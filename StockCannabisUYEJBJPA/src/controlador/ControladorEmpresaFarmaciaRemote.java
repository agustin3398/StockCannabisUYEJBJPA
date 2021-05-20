package controlador;


import java.util.List;

import javax.ejb.Remote;

import entidades.EmpresaFarmacia;

@Remote
public interface ControladorEmpresaFarmaciaRemote {

	public void crearNuevaEmpresaFarmacia(EmpresaFarmacia empresaFarmacia);

	public List<EmpresaFarmacia> obtenerTodasEmpresaFarmacia();

}
