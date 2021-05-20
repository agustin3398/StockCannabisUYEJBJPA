package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idusuario;

	private String contrasenia;

	private String usuario;

	//bi-directional many-to-one association to EmpresaFarmacia
	@OneToMany(mappedBy="usuario")
	private List<EmpresaFarmacia> empresaFarmacias;

	public Usuario() {
	}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<EmpresaFarmacia> getEmpresaFarmacias() {
		return this.empresaFarmacias;
	}

	public void setEmpresaFarmacias(List<EmpresaFarmacia> empresaFarmacias) {
		this.empresaFarmacias = empresaFarmacias;
	}

	public EmpresaFarmacia addEmpresaFarmacias(EmpresaFarmacia empresaFarmacias) {
		getEmpresaFarmacias().add(empresaFarmacias);
		empresaFarmacias.setUsuario(this);

		return empresaFarmacias;
	}

	public EmpresaFarmacia removeEmpresaFarmacias1(EmpresaFarmacia empresaFarmacias) {
		getEmpresaFarmacias().remove(empresaFarmacias);
		empresaFarmacias.setUsuario(null);

		return empresaFarmacias;
	}


}