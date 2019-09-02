package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves14 extends SorteRevesAbs {

	public SorteReves14()
	{
		setNumber(14);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(75);
		return "----  SORTE  ----\nVendeu a parte de sua empresa para um investidor\nReceba R$ 75,00";
	}
}
