package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;

public class SorteReves5 extends SorteRevesAbs {

	public SorteReves5()
	{
		setNumber(5);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		jogadorDaVez.setTemHabeas(true);
		return "Utilize este cartão para se livrar da prisão";
	}
}