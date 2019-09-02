package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public class SorteReves2 extends SorteRevesAbs {

	public SorteReves2()
	{
		setNumber(2);
	}
	
	public String funcaoCarta(Listas lista)
	{
		for(Jogador jogador: lista.getJogadores())
		{
			jogador.receberTaxa(50);
		}
		return "----  SORTE  ----\nO dia do seu casamento chegou, receba os presentes\nReceba R$ 50,00 (De cada Jogador)";
	}
}