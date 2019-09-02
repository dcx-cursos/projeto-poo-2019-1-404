package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves27 extends SorteRevesAbs {

	public SorteReves27()
	{
		setNumber(27);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(80);
		return "----  SORTE  ----\nGanhou sozinho na loteria\nReceba R$ 80,00";
	}
}
