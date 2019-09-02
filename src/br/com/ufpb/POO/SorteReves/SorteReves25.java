package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves25 extends SorteRevesAbs {

	public SorteReves25()
	{
		setNumber(25);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(9);
		return "----  REVES  ----\nSeu jatinho precisa de manutenção\nPague R$ 9,00";
	}
}
