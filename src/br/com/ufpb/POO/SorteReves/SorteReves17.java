package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves17 extends SorteRevesAbs {

	public SorteReves17()
	{
		setNumber(17);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(75);
		return "----  SORTE  ----\nRecebeu uma herança inesperada\nReceba R$ 75,00";
	}
}
