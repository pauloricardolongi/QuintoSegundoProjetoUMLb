package model.servico;

public class TaxServBrasil {
	
	public double taxa(double quantia) {
		if(quantia <= 100.0) {
			return quantia * 20 / 100;
		}
		else {
			return quantia * 15 / 100;
		}
	}

}
