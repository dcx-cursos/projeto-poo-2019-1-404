package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves19 extends SorteRevesAbs {

	public SorteReves19()
	{
		setNumber(19);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(60);
		return "----  SORTE  ----\nSua casa ser� desapropriada para a constru��o de um metro e ganhar� uma gorda indeniza��o\nReceba R$ 60,00";
	}
}
