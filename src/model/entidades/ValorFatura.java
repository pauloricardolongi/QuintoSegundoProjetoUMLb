package model.entidades;

public class ValorFatura {
	private Double pagBasico;
	private Double taxaImposto;
	
	public ValorFatura() {
		
	}

	public ValorFatura(Double pagBasico, Double taxaImposto) {
		
		this.pagBasico = pagBasico;
		this.taxaImposto = taxaImposto;
	}

	public Double getPagBasico() {
		return pagBasico;
	}

	public void setPagBasico(Double pagBasico) {
		this.pagBasico = pagBasico;
	}

	public Double getTaxaImposto() {
		return taxaImposto;
	}

	public void setTaxaImposto(Double taxaImposto) {
		this.taxaImposto = taxaImposto;
	}

	public Double getPagamentoTotal() {
		return getPagBasico() + getTaxaImposto();
	}
}
