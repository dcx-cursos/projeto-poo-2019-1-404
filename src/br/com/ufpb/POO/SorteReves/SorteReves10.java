package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves10 extends SorteRevesAbs {

	public SorteReves10()
	{
		setNumber(10);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(20);
		return "----  REVES  ----\nFérias com a familia\nPague R$ 20,00";
	}
}
