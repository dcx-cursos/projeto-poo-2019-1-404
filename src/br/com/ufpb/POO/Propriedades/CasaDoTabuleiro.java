package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo CasaDoTabuleiro, onde serão contidos, valores e métodos para os mesmos.
 */

import java.util.ArrayList;

import br.com.ufpb.POO.Jogador;

public class CasaDoTabuleiro {

	private String nome;
	private ArrayList<Jogador> jogadoresNaCasa;
	private int indice;

	//Construtor
	public CasaDoTabuleiro() {
		this.jogadoresNaCasa = new ArrayList<Jogador>();
	}
	
	// Construtor
	public CasaDoTabuleiro(String nome, int indice) {
		this.nome = nome;
		this.indice = indice;
		this.jogadoresNaCasa = new ArrayList<Jogador>();
	}
	
	/** Método para retornar o nome da casa do tabuleiro
	 * @return String - Nome da Casa
	 */
	public String getNome(){
		return nome;
	}
	
	/** Método para setar o nome da casa do tabuleiro
	 * @param nome String - Nome da casa do tabuleiro
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
 
	/** Método para retornar indice da casa do tabuleiro
	 * @return int - Indice da casa
	 */
	public int getIndice() {
		return this.indice;
	}

	/** Método para setar o indice da casa do tabuleiro
	 *  @param indice int - Indice da casa do tabuleiro
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	/** Método para retornar a lista de jogadores
	 *  @return ArrayList<Jogador> - Lista do tipo Jogador
	 */
	public ArrayList<Jogador> getJogadoresNaCasa() {
		return this.jogadoresNaCasa;
	}
	
	/** Método para setar/modificar a lista do tipo Jogador
	 *  @param jogadoresNaCasa ArrayList<Jogador> - Lista do tipo Jogador
	 */
	public void setJogadoresNaCasa(ArrayList<Jogador> jogadoresNaCasa) {
		this.jogadoresNaCasa = jogadoresNaCasa;
	}
	
	/** Método para adicionar jogador na lista de jogadores
	 *  @param jogador Jogador - Jogador a ser adicionado na lista
	 */
	public void adicionarJogadoresNaListaDaCasa(Jogador jogador) {
		this.jogadoresNaCasa.add(jogador);
	}

	/** Método para remover jogador da lista de jogadores na casa 
	 *  @param jogador Jogador - Jogador a ser removido da lista
	 */
	public void removerJogadoresDaListaDaCasa(Jogador jogador) {
		this.jogadoresNaCasa.remove(jogador);
	}

	/** Método para mover jogador para uma casa do tabuleiro
	 * 	@param jogador Jogador - Jogador a ser movido
	 * 	@param destino CasaDoTabuleiro - Casa para onde o jogador será movido
	 */
	public void mover(Jogador jogador, CasaDoTabuleiro destino) {
		CasaDoTabuleiro origem = jogador.getPos();
		jogador.setPos(destino);
		jogador.setIdAtualDoJogador(destino.getIndice());
		destino.adicionarJogadoresNaListaDaCasa(jogador);
		origem.removerJogadoresDaListaDaCasa(jogador);
	}

	/** Método para informar que ocorreu um erro
	 *  @param jogador Jogador - Jogador que recebeu o erro
	 */
	public void funcaoTabuleiro(Jogador jogador) {
		System.out.print("Ocorreu um erro!");
	}

}
