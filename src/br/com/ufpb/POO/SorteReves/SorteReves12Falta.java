package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.ControlesTabuleiro;
import br.com.ufpb.POO.Jogador;

public class SorteReves12Falta extends SorteRevesAbs {
	
	private ControlesTabuleiro controles;

	public SorteReves12Falta()
	{
		setNumber(12);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
//		this.controles.jogardadosCarta();
		return "----  SORTE  ----\nJogue os dados novamente";
	}
}
