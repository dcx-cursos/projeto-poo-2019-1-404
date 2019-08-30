package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public class SorteReves2 extends SorteRevesAbs {

	public SorteReves2()
	{
		setNumber(2);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez, Listas lista)
	{
		for(Jogador jogador: lista.getJogadores())
		{
			jogador.receberTaxa(50);
		}
		return "O dia do seu casamento chegou, receba os presentes";
	}
}