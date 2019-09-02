package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public class SorteReves6 extends SorteRevesAbs {

	public SorteReves6(){
		setNumber(6);
	}
	
	public String funcaoCarta(Jogador jogador, Listas lista){
		System.out.println("----  REVES  ----");
		lista.getTabuleiro().get(30).funcaoTabuleiro(jogador);
		return "Prisão Visitante";
	}
}