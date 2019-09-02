package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves31 extends SorteRevesAbs {

	public SorteReves31()
	{
		setNumber(31);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(100);
		return "----  SORTE  ----\nTirou primeiro lugar no torneio de golfe receba\nReceba R$ 100,00";
	}
}
