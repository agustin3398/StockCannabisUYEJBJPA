package DAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import entidades.EmpresaFarmacia;

@Stateless
@LocalBean
public class DAOEmpresaFarmacia {

	@PersistenceContext
	private EntityManager em;

	public DAOEmpresaFarmacia() {

	}

	public void crearEmpresaFarmacia(EmpresaFarmacia empresaFarmacia) {
		try {
			em.persist(empresaFarmacia);
			em.flush();
		} catch (PersistenceException e) {
			e.printStackTrace();
			System.out.println("Hubo un error al crear la EmpresaFarmacia");
			System.out.println("Clase: DaoEmpresaFarmacia");
			System.out.println("Metodo: crearEmpresaFarmacia");
			System.out.println("****************************");
		}
	}

	@SuppressWarnings("unchecked")
	public List<EmpresaFarmacia> obtenerEmpresasFarmacias() {
		List<EmpresaFarmacia> emprFarm = null;
		try {
			emprFarm = em.createNamedQuery("EmpresaFarmacia.findAll").getResultList();
			return emprFarm;
		} catch (PersistenceException e) {
			System.out.println("Hubo un error al obtenerEmpresasFarmacias");
			System.out.println("Clase: DaoEmpresaFarmacia");
			System.out.println("Metodo: obtenerEmpresasFarmacias");
			System.out.println("****************************");
		}
		return emprFarm;
	}

}
