package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves4 extends SorteRevesAbs {

	public SorteReves4()
	{
		setNumber(4);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(50);
		return "Seu livro será publicado por uma grande editora";
	}
}
