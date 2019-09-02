package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves28 extends SorteRevesAbs {

	public SorteReves28()
	{
		setNumber(28);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(30);
		return "---- REVES  ----\nAtualizou os computadores da sua empresa\nPague R$ 30,00";
	}
}
