package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves21 extends SorteRevesAbs {

	public SorteReves21()
	{
		setNumber(21);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(25);
		return "---- SORTE  ----\nSeu iate afundou, mas você tinha seguro!\nReceba R$ 25,00";
	}
}
