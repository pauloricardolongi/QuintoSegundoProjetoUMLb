package model.servico;

import model.entidades.AluguelAutomovel;
import model.entidades.ValorFatura;

public class ServicoAluguel {
	private Double precoPorHora;
	private Double precoPorDia;
	
	private TaxServBrasil taxa_serv_brasil;
	
	public ServicoAluguel() {
		
	}

	public ServicoAluguel(Double precoPorHora, Double precoPorDia, TaxServBrasil taxa_serv_brasil) {
		
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.taxa_serv_brasil = taxa_serv_brasil;
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
		double taxaImposto= taxa_serv_brasil.taxa(pagBasico);
		aluguel_automovel.setValorFatura(new ValorFatura(pagBasico, taxaImposto));
	} 
}
