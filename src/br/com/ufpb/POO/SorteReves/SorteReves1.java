package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves1 extends SorteRevesAbs {

	public SorteReves1()
	{
		setNumber(1);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(200);
		return "----  REVES  ----\nSua empresa foi multada por poluir demais\nPague R$ 200,00";
	}
}
