package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.ControlesTabuleiro;
import br.com.ufpb.POO.Jogador;

public class SorteReves24 extends SorteRevesAbs {

	//private ControlesTabuleiro controle = new ControlesTabuleiro();

	
	public SorteReves24()
	{
		setNumber(24);
	}
	
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		/*
		if(controle.dados.resultado()%2 == 0) {
			jogadorDaVez.receberTaxa(100);
		}else if(controle.dados.resultado()%2 != 0) {
			jogadorDaVez.pagarTaxa(100);
		}*/
		return "----  SORTE / REVES  ----\nSorte se tirou o número par da soma dos dados e revés caso contrário\nReceba R$ 100,00\nPague R$ 100,00";
	}
}
