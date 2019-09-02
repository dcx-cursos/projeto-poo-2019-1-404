package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves26 extends SorteRevesAbs {

	public SorteReves26()
	{
		setNumber(26);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(100);
		return "---- REVES  ----\nRenovou a frota de carros da sua empresa\nPague R$ 100,00";
	}
}
