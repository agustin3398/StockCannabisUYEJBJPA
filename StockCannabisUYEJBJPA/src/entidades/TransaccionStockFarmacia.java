package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transaccion_stock_farmacia database table.
 * 
 */
@Entity
@Table(name="transaccion_stock_farmacia")
@NamedQuery(name="TransaccionStockFarmacia.findAll", query="SELECT t FROM TransaccionStockFarmacia t")
public class TransaccionStockFarmacia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtransaccion_stock_farmacia")
	private int idtransaccionStockFarmacia;

	private int cantidadActual;

	@Temporal(TemporalType.DATE)
	private Date fechaProximaEntradaStock;

	private byte hayStockDisponible;

	//bi-directional many-to-one association to EmpresaFarmacia
	@ManyToOne
	@JoinColumn(name="idEmpresaFarmacia")
	private EmpresaFarmacia empresaFarmacia;

	public TransaccionStockFarmacia() {
	}

	public int getIdtransaccionStockFarmacia() {
		return this.idtransaccionStockFarmacia;
	}

	public void setIdtransaccionStockFarmacia(int idtransaccionStockFarmacia) {
		this.idtransaccionStockFarmacia = idtransaccionStockFarmacia;
	}

	public int getCantidadActual() {
		return this.cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public Date getFechaProximaEntradaStock() {
		return this.fechaProximaEntradaStock;
	}

	public void setFechaProximaEntradaStock(Date fechaProximaEntradaStock) {
		this.fechaProximaEntradaStock = fechaProximaEntradaStock;
	}

	public byte getHayStockDisponible() {
		return this.hayStockDisponible;
	}

	public void setHayStockDisponible(byte hayStockDisponible) {
		this.hayStockDisponible = hayStockDisponible;
	}

	public EmpresaFarmacia getEmpresaFarmacia() {
		return this.empresaFarmacia;
	}

	public void setEmpresaFarmacia(EmpresaFarmacia empresaFarmacia) {
		this.empresaFarmacia = empresaFarmacia;
	}

}