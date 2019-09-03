package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.ControlesTabuleiro;
import br.com.ufpb.POO.Jogador;

public class SorteReves12 extends SorteRevesAbs {
	
	private ControlesTabuleiro controles;

	public SorteReves12()
	{
		setNumber(12);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
//		this.controles.jogardadosCarta();
		return "----  SORTE  ----\nJogue os dados novamente";
	}
}
