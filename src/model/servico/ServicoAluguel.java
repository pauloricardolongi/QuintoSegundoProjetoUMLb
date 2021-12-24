package model.servico;

import model.entidades.AluguelAutomovel;

import model.entidades.ValorFatura;

public class ServicoAluguel {
	private Double precoPorHora;
	private Double precoPorDia;
	
	private TaxaServico taxaServico; 
	
	public ServicoAluguel() {
		
	}

	public ServicoAluguel(Double precoPorHora, Double precoPorDia, TaxaServico taxaServico) {
		
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.taxaServico = taxaServico;
	}

	public void processoFatura(AluguelAutomovel aluguel_automovel) {
		long t1 = aluguel_automovel.getInicio().getTime();
		long t2 = aluguel_automovel.getFim().getTime();
		//converter milesegundos em horas
		double horas = (double) (t2 - t1)/1000/60/60;
		
		double pagBasico;
		if (horas <= 12.0) {
			pagBasico = Math.ceil(horas) * precoPorHora;
		}else {
			pagBasico = Math.ceil(horas/24)* precoPorDia;
		}
		//calcular imposto
		double taxaImposto= taxaServico.taxa(pagBasico);
		aluguel_automovel.setValorFatura(new ValorFatura(pagBasico, taxaImposto));
	} 
}
