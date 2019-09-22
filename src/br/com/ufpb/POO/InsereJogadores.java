package br.com.ufpb.POO;

/**Classe para objetos do tipo InsereJogadores, onde serão contidos, valores e métodos para o mesmo.
 *@author Anderson, Ismar, Jobson, Josué
 */

import java.util.ArrayList;

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;

public class InsereJogadores {
	private ArrayList<String> cores = new ArrayList<String>();
	
	public InsereJogadores() {
		iniciarCores();
	}

	/**Método para adicionar cores a lista de cores, do peão,  a serem escolhidas pelo Jogador*/

	public void iniciarCores(){
		cores.add("preto");
		cores.add("branco");
		cores.add("vermelho");
		cores.add("verde");
		cores.add("azul");
		cores.add("amarelo");
		cores.add("laranja");
		cores.add("rosa");
	}
	
	/**Método get de Cores*/
	public ArrayList<String> getCores(){	
		return this.cores;
	}
	
	/**Método para cria a string printCores pode ficar sendo atualizada com a lista atual de cores*/
	
	public String criaPrintCores() {
		String printCores = "";
		for(String cor: this.cores) {
			printCores += "["+cor+"]";
		}
		return printCores;
	}
	
	/**Método para realizar a inserção de jogadores ao jogo*/

	public void inserirJogador(String nome, String corPeao) {
		CasaDoTabuleiro pontoDePartida = Listas.getInstance().getTabuleiro().get(0);
		Listas.getInstance().addJogador(new Jogador(nome, corPeao, pontoDePartida, 1500));
		cores.remove(corPeao);
	}
	
	public void inserirJogadoresNaCasaDePartida()
	{
		Listas.getInstance().addListaDeJogadoresNaCasaDePartida();

	}
}
