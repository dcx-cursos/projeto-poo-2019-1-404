package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo PropriedadeEspecialSorteReves
 */
import java.util.ArrayList;

import br.com.ufpb.POO.Jogador;

public class PropriedadeEspecialSorteReves extends PropriedadeEspecial {
	private ArrayList<Integer> cartas;
	
	//Construtor
	public PropriedadeEspecialSorteReves(String nome, int indice) {
		super(nome, indice);
	}
	
	/** AINDA SERÁ IMPLEMENTADO
	 * @param jogador Jogador 
	 */
	public void funcaoTabuleiro(Jogador jogador) {
//		System.out.print("Sorte ou Revés, "+jogador.getNome()+" nada acontece!\n");
		System.out.println(""+this.getNome()+": função tabuleiro ok!");
	}
}
