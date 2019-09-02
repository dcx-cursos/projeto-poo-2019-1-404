package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves20 extends SorteRevesAbs {

	public SorteReves20()
	{
		setNumber(20);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(150);
		return "----  SORTE  ----\nVenceu licitação para grande obra\nReceba R$ 150,00";
	}
}
