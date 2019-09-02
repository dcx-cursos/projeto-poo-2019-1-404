package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves16 extends SorteRevesAbs {

	public SorteReves16()
	{
		setNumber(16);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.pagarTaxa(45);
		return "----  REVES  ----\nA falta de chuva prejudicou a colheita\nPague R$ 45,00";
	}
}
