package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves15 extends SorteRevesAbs {

	public SorteReves15()
	{
		setNumber(15);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(100);
		return "----  SORTE  ----\nApostou no cavalo azarão e ganhou\nReceba R$ 100,00";
	}
}
