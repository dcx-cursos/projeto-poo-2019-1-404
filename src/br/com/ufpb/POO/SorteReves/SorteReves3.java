package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public class SorteReves3 extends SorteRevesAbs {

	public SorteReves3()
	{
		setNumber(3);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez, Listas lista)
	{
		jogadorDaVez.pagarTaxa(50);
		return "Reformou sua casa";
	}
}