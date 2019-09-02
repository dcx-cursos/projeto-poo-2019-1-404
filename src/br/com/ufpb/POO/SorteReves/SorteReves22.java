package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves22 extends SorteRevesAbs {

	public SorteReves22()
	{
		setNumber(22);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(30);
		return "----  REVES  ----\nSeus funcionários entraram em greve\nPague R$ 30,00";
	}
}
