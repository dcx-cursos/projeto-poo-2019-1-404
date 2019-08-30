package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo PropriedadeEspecialSorteReves
 */
import java.util.ArrayList;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public class PropriedadeEspecialSorteReves extends PropriedadeEspecial {
	private Listas lista;
	
	//Construtor
	public PropriedadeEspecialSorteReves(String nome, int indice, Listas lista) {
		super(nome, indice);
		this.lista = lista;
	}
	
	/** AINDA SERÁ IMPLEMENTADO
	 * @param jogador Jogador 
	 */
	public void funcaoTabuleiro(Jogador jogador) {
//		System.out.print("Sorte ou Revés, "+jogador.getNome()+" nada acontece!\n");
		System.out.println(""+this.getNome()+": função tabuleiro ok!");
	}
}
