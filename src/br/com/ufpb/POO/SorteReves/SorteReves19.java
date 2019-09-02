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
		return "----  SORTE  ----\nSua casa será desapropriada para a construção de um metro e ganhará uma gorda indenização\nReceba R$ 60,00";
	}
}
