package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves3 extends SorteRevesAbs {

	public SorteReves3()
	{
		setNumber(3);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(50);
		return "----  REVES  ----\nReformou sua casa\nPague R$ 50,00";
	}
}