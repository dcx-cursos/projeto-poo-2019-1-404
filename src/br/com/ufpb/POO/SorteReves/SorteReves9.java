package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves9 extends SorteRevesAbs {

	public SorteReves9()
	{
		setNumber(9);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(20);
		return "----  REVES  ----\nVocê vai começar um curso de MBA e ganhou um bom desconto para pagamento a vista\nPague R$ 20,00";
	}
}
