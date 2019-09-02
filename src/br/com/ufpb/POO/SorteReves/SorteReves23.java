package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves23 extends SorteRevesAbs {

	public SorteReves23()
	{
		setNumber(23);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(22);
		return "----  REVES  ----\nComprou obra de arte falsificada\nPague R$ 22,00";
	}
}
