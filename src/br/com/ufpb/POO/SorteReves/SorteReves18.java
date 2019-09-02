package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves18 extends SorteRevesAbs {

	public SorteReves18()
	{
		setNumber(18);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(20);
		return "----  REVES  ----\nSeu filho decidiu fazer intercâmbio\nPague R$ 20,00";
	}
}
