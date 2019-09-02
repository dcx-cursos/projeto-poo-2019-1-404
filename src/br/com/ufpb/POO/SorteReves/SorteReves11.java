package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves11 extends SorteRevesAbs {

	public SorteReves11()
	{
		setNumber(11);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.receberTaxa(10);
		return "----  SORTE  ----\nRecebeu o prêmio de profissional do ano e ganhou um carro\nReceba R$ 10,00";
	}
}
