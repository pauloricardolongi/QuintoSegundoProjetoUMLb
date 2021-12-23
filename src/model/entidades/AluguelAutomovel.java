package model.entidades;

import java.util.Date;

public class AluguelAutomovel {

	private Date inicio;
	private Date fim;
	
	private Automovel automovel;
	private ValorFatura valorFatura;
	
	public AluguelAutomovel() {
		
	}

	public AluguelAutomovel(Date inicio, Date fim, Automovel automovel) {
		
		this.inicio = inicio;
		this.fim = fim;
		this.automovel = automovel;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public ValorFatura getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(ValorFatura valorFatura) {
		this.valorFatura = valorFatura;
	}
}
