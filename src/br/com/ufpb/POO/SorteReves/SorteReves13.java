package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves13 extends SorteRevesAbs {

	public SorteReves13()
	{
		setNumber(13);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(50);
		return "----  REVES  ----\nSua empresa ir� patrocinar uma expedi��o a Ant�rtida\nPague R$ 50,00";
	}
}
