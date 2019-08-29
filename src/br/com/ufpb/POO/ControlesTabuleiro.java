package br.com.ufpb.POO;

/**Classe para objetos do tipo ControlesTabuleiro, onde serão contido, valores e métodos do mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.Verificadores.VerificadoresDojogo;

public class ControlesTabuleiro {
	private Tabuleiro tabuleiro;
	private Jogador jogadorDaVez;
	private boolean executando = true;
	private Listas listas;
	private InsereJogadores insereJogadores;
	private ObterProxId obterProxId;
	private Scanner scan;
	private Dados dados = new Dados();
	private VerificadoresDojogo verificador = new VerificadoresDojogo();
	
	public ControlesTabuleiro() {
		this.listas = new Listas();
		this.tabuleiro = new Tabuleiro(this.listas);
		this.obterProxId = new ObterProxId();
		this.insereJogadores = new InsereJogadores(this.listas);
		this.scan = new Scanner(System.in);
		iniciarJogo();
	}

	/**Método para inserir jogadores, onde realiza a chamada do método inciaJogadorDaVez*/
	
	public void inserirJogadores() {
		this.insereJogadores.inserirJogador();
		iniciaJogadorDaVez();
	}

	/**Método para iniciar o Jogador da vez, onde realiza a chamada do método options*/
	
	public void iniciaJogadorDaVez() {
		this.jogadorDaVez = this.listas.getPrimeiroJogador();
		System.out.println("O Banco Imobiliário vai começar. Aproveite!");
		options(this.jogadorDaVez);
	}

	/**Método para mover o Jogador pelo tabuleiro
	 * @param Jogador - Jogador da vez
	 * @param CasaDoTabuleiro - destino do Jogador*/
	
	public void moverJogador(Jogador jogadorDaVez, CasaDoTabuleiro destino) {
		destino.mover(this.jogadorDaVez, destino);
	}

	/**Método que altera o Jogador da vez
	 * @param int - id do Jogador da vez
	 * @param ArrayList<Jogador> - lista de jogadores*/
	
	public void mudaJogadorDaVez(int idJogador, ArrayList<Jogador> jogadores) {
		int id = this.obterProxId.obterIdProxJogador(idJogador, jogadores);
		this.jogadorDaVez = this.listas.getJogadorId(id);
//		System.out.println(this.jogadorDaVez = this.listas.getJogadorId(id));
//		if(listas.getJogadoresPresos().contains(this.jogadorDaVez)) {
//			System.out.print("Jogador"+this.jogadorDaVez.getNome()+" está preso!");
//			int novoId = this.jogadorDaVez.getId();
//			this.jogadorDaVez = this.listas.getJogadorId(this.obterProxId.obterIdProxJogador(novoId, jogadores));
//		}
		}

	/**Método para realizar o "lançamento" dos dados*/
	
	public void jogarDados() {
		dados.lancarDados();
		int indiceCasaDestino = this.obterProxId.obterIdProxCasa(this.jogadorDaVez.getIdAtualDoJogador(), dados.resultado(), this.jogadorDaVez);
		System.out.println("O jogador "+this.jogadorDaVez.getNome()+" ("+this.jogadorDaVez.getCorPeao()+") tirou "+dados.getDado1()+","+dados.getDado2()+
		" o peão avançou para "+indiceCasaDestino+" - "+this.listas.getTabuleiro().get(indiceCasaDestino).getNome());
		moverJogador(jogadorDaVez, this.listas.getCasaById(indiceCasaDestino));
		this.listas.getCasaById(indiceCasaDestino).funcaoTabuleiro(jogadorDaVez);
		/*
		if (qtdJogadasSeguidas >= 3) {
			System.out.println("O jogador jogou 3 vezes seguidas, o jogador ser� preso por trapacear");
		}
		if(dados.dado1 == dados.dado2) {
			qtdJogadasSeguidas += 1;
			jogarDados();
		}
		*/
	}

	/**Método para verificar se o Jogador realmente deseja sair*/
	
	public void optionSair(){
		System.out.println("Deseja realmente sair?[s/n]");
		String escolha2 = this.scan.nextLine().toUpperCase();
		if(escolha2.equals("S")) {
			this.listas.setJogadoresJogando(jogadorDaVez);
		} else if(!escolha2.equals("N")) {
			System.out.println("Comando indisponível!");
			optionSair();
		}
	}

	/**Método que mostra as opções(operações) do jogo para o jogador, onde realiza a chamada de todos os métodos que sejam necessarios para realizar essas operações.
	 * @param Jogador - Jogador da vez*/
	
	public void options(Jogador jogadorDaVez) {
		if(this.listas.getJogadoresJogando().size()>1){
			System.out.print("A jogada de "+jogadorDaVez.getNome()+" ("+jogadorDaVez.getCorPeao()+") começou.\n");
			System.out.println("Comandos disponíveis: [jogar][status][sair]");
			System.out.print("Entre com um comando: ");
			String escolha = this.scan.nextLine().toUpperCase();
			if(escolha.equals("S") || escolha.equals("SAIR")) {
				optionSair();
			} if (escolha.equals("J") || escolha.equals("JOGAR")) {
				jogarDados();
			} if(escolha.equals("STATUS")){
				System.out.println(jogadorDaVez.toStatus());
				options(jogadorDaVez);
			}
			mudaJogadorDaVez(jogadorDaVez.getId(), this.listas.getJogadoresJogando());
			options(this.jogadorDaVez);
		} else {
			this.executando = false;
		}
	}

	/**Método que inicia o Jogo, onde realiza a chamada do método do inserirJogadores*/
	
	public void iniciarJogo() {
		if(this.executando) {
			inserirJogadores();
		}
		System.out.println("Jogador "+this.listas.getJogadoresJogando().get(0).getNome()+" - "+this.listas.getJogadoresJogando().get(0).getCorPeao()+", é o Vencedor!");			
	}
}
