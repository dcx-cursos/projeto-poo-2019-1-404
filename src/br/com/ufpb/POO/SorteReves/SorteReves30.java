package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves30 extends SorteRevesAbs {

	public SorteReves30()
	{
		setNumber(30);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(60);
		return "----  REVES  ----\nProdução de leite de suas fazendas ficou abaixo da expectativa\nPague R$ 60,00";
	}
}
