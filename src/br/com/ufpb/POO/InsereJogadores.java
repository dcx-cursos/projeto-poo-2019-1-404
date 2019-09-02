package br.com.ufpb.POO;

/**Classe para objetos do tipo InsereJogadores, onde serão contidos, valores e métodos para o mesmo.
 *@author Anderson, Ismar, Jobson, Josué
 */

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.Verificadores.VerificadoresDojogo;

public class InsereJogadores {
	private Listas listas;
	private Scanner scan;
	private ArrayList<String> cores = new ArrayList<String>();
	private VerificadoresDojogo v = new VerificadoresDojogo();
	
	public InsereJogadores(Listas listas) {
		this.listas = listas;
		this.scan = new Scanner(System.in);
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
	
	/**Método para receber a quantidade de jogadores para a partida*/
	
	public int recebeQuantidadeJogadores() {
		System.out.print("Digite o nÃºmero de jogadores [2-8]: ");
		String n = this.scan.nextLine();
		if(v.ValorisValido(n)) {
			return Integer.parseInt(n);
		}
		return recebeQuantidadeJogadores();
	}
	
	/**Método para cria a string printCores pode ficar sendo atualizada com a lista atual de cores*/
	
	public String criaPrintCores() {
		String printCores = "";
		for(String cor: this.cores) {
			printCores += "["+cor+"]";
		}
		return printCores;
	}
	
	/**Método para receber nome do jogador*/
	
	public String recebeNomeJogador(int k) {
		System.out.print("Digite o nome do Jogador "+(k+1)+": ");
		String nome = this.scan.nextLine();
		if(v.nomeIsValido(nome, listas.getJogadores())) {
			return nome;
		}
		return recebeNomeJogador(k);
	}
	
	/**Método para receber a cor escolhida pelo Jogador para o peão*/
	
	public String recebeCorPeao(int k, String printCores) {
		System.out.print("Escolha a cor do peão do jogador "+(k+1)+" entre as opções seguintes:\n"+printCores+"\n: ");
		String corPeao = this.scan.nextLine();
		if(v.corExiste(corPeao, cores)) {
			return corPeao;
		}
		return recebeCorPeao(k,printCores);
	}
	/**Método para realizar a inserção de jogadores ao jogo*/

	public void inserirJogador() {
		CasaDoTabuleiro pontoDePartida = this.listas.getTabuleiro().get(0);
		int n = recebeQuantidadeJogadores();
	    iniciarCores();
		for(int k = 0; k < n;) {
			String printCores = criaPrintCores();
			String nome = recebeNomeJogador(k);
			String corPeao = recebeCorPeao(k,printCores);
			this.listas.addJogador(new Jogador(nome, corPeao, pontoDePartida, 1500));
			cores.remove(corPeao);
			k++;
		}
		this.listas.addListaDeJogadoresNaCasaDePartida();
	}
}
