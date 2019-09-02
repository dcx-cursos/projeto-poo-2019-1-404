package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves8 extends SorteRevesAbs {

	public SorteReves8()
	{
		setNumber(8);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(100);
		return "----  SORTE  ----\nSuas ações na bolsa de valores estão em alta\nReceba R$ 100,00";
	}
}
