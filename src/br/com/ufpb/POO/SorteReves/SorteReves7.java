package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;
import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;

public class SorteReves7 extends SorteRevesAbs {
	private CasaDoTabuleiro casa = new CasaDoTabuleiro();
	
	public SorteReves7()
	{
		setNumber(7);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez, Listas lista)
	{
		casa.mover(jogadorDaVez, lista.getCasaById(0));
		lista.getCasaById(0).funcaoTabuleiro(jogadorDaVez);
		return "----  SORTE  ----\nVá até o início\nReceba R$ 200,00";
	}
}