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
		return "----  REVES  ----\nSua empresa irá patrocinar uma expedição a Antártida\nPague R$ 50,00";
	}
}
