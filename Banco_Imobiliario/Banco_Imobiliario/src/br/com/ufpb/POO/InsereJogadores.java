package br.com.ufpb.POO;

/**Classe para objetos do tipo InsereJogadores, onde serão contidos, valores e métodos para o mesmo.
 */

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;

public class InsereJogadores {
	private Listas listas;
	private Scanner scan;
	private ArrayList<String> cores = new ArrayList<String>();
	
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
	
	/**Método para realizar a inserção de jogadores ao jogo*/

	public void inserirJogador() {
		String printCores = "";
		CasaDoTabuleiro pontoDePartida = this.listas.getTabuleiro().get(0);
		System.out.print("Digite o número de jogadores [2-8]: ");
		int n = Integer.parseInt(this.scan.nextLine());
		if (n>1 && n<9){
		    iniciarCores();

			for(int k = 0; k < n;) {
				for(String cor: this.cores) {
					printCores += "["+cor+"]";
				}
			System.out.print("Digite o nome do Jogador "+(k+1)+": ");
			String nome = this.scan.nextLine();
			System.out.print("Escolha a cor do peão do jogador "+(k+1)+" entre as opções seguintes:\n"+printCores+"\n: ");
			String corPeao = this.scan.nextLine();
			while(!cores.contains(corPeao)){ 
				System.out.println("Digite uma cor válida!");
				corPeao = scan.nextLine();
			}
			this.listas.addJogador(new Jogador(nome, corPeao, pontoDePartida, 1500));
			cores.remove(corPeao);
			printCores = "";
			k++;
		}
		this.listas.addListaDeJogadoresNaCasaDePartida();
		} else if(n<2 || n>8) {
			System.out.println("Número de jogadores indisponível.");
			inserirJogador();
		}
	}
}
