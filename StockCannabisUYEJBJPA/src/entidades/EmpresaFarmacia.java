package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa_farmacia database table.
 * 
 */
@Entity
@Table(name="empresa_farmacia")
@NamedQuery(name="EmpresaFarmacia.findAll", query="SELECT e FROM EmpresaFarmacia e")
public class EmpresaFarmacia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idempresaFarmacia;

	private String departamento;

	private String direccion;

	private String localidad;

	private String nombreFantasia;

	private String razonSocial;

	private String rut;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioAsociado")
	private Usuario usuario;

	//bi-directional many-to-one association to TransaccionStockFarmacia
	@OneToMany(mappedBy="empresaFarmacia")
	private List<TransaccionStockFarmacia> transaccionStockFarmacias;

	public EmpresaFarmacia() {
	}

	public int getIdempresaFarmacia() {
		return this.idempresaFarmacia;
	}

	public void setIdempresaFarmacia(int idempresaFarmacia) {
		this.idempresaFarmacia = idempresaFarmacia;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNombreFantasia() {
		return this.nombreFantasia;
	}

	public void setNombreFantasia(String nombreFantasia) {
		this.nombreFantasia = nombreFantasia;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario1) {
		this.usuario = usuario1;
	}

	public List<TransaccionStockFarmacia> getTransaccionStockFarmacias() {
		return this.transaccionStockFarmacias;
	}

	public void setTransaccionStockFarmacias(List<TransaccionStockFarmacia> transaccionStockFarmacias) {
		this.transaccionStockFarmacias = transaccionStockFarmacias;
	}

	public TransaccionStockFarmacia addTransaccionStockFarmacia(TransaccionStockFarmacia transaccionStockFarmacia) {
		getTransaccionStockFarmacias().add(transaccionStockFarmacia);
		transaccionStockFarmacia.setEmpresaFarmacia(this);

		return transaccionStockFarmacia;
	}

	public TransaccionStockFarmacia removeTransaccionStockFarmacia(TransaccionStockFarmacia transaccionStockFarmacia) {
		getTransaccionStockFarmacias().remove(transaccionStockFarmacia);
		transaccionStockFarmacia.setEmpresaFarmacia(null);

		return transaccionStockFarmacia;
	}

}