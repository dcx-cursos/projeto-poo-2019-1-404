package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves29 extends SorteRevesAbs {

	public SorteReves29()
	{
		setNumber(29);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(40);
		return "----  REVES  ----\nUm navio afundou com suas mercadorias (não tinha seguro)\nPague R$ 40,00";
	}
}
