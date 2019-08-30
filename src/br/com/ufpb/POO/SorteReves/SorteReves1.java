package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public class SorteReves1 extends SorteRevesAbs {

	public SorteReves1()
	{
		setNumber(1);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez, Listas lista)
	{
		jogadorDaVez.pagarTaxa(200);
		return "Sua empresa foi multada por poluir demais";
	}
}
