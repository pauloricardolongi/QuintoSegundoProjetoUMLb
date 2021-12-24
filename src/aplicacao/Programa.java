package aplicacao;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.AluguelAutomovel;
import model.entidades.Automovel;
import model.servico.ServicoAluguel;
import model.servico.TaxServBrasil;

public class Programa {

	public static void main(String[] args)throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Entre com os dados do aluguel do ve�culo:");
		System.out.print("Modelo do ve�culo: ");
		String modeloVeiculo= sc.nextLine();
		System.out.print("Data de retirada do ve�culo:(dd/MM/yyyy HH:ss)");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Data de devolu��o do ve�culo:(dd/MM/yyyy HH:ss)");
		Date fim = sdf.parse(sc.nextLine());
		
		AluguelAutomovel aluguelAutomovel = new AluguelAutomovel(inicio, fim, new Automovel(modeloVeiculo));	
		System.out.print("Entre pre�o por hora");
		double precoPorHora = sc.nextDouble();
		System.out.print("Entre pre�o por dia");
		double precoPorDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorHora, precoPorDia, new TaxServBrasil());
		
		servicoAluguel.processoFatura(aluguelAutomovel);
		System.out.println("FATURA:");
		System.out.println("Pagamento B�sico " + String.format("%.2f", aluguelAutomovel.getValorFatura().getPagBasico()));
		System.out.println("Imposto " + String.format("%.2f", aluguelAutomovel.getValorFatura().getTaxaImposto()));
		System.out.println("Total pagamento " + String.format("%.2f", aluguelAutomovel.getValorFatura().getPagamentoTotal()));

		
		sc.close();
	}

}
