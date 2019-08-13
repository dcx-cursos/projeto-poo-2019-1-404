package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo Ponto_de_Partida, onde serão contidos, valores e métodos para os mesmos.
 */
import br.com.ufpb.POO.Jogador;

public class Ponto_de_Partida extends CasaDoTabuleiro {
	
	//Construtor
	public Ponto_de_Partida(String nome, int indice) {
		super(nome, indice);
	}
	
	/** Método para inicializar o jogador no tabuleiro e atribuir 200 de créditos
	 *  @param jogador Jogador - Jogador que é inicializado no tabuleiro
	 */
	public void funcaoTabuleiro(Jogador jogador) {
		System.out.println("Ponto de Partida, "+jogador.getNome()+" recebe $200");
		jogador.receberTaxa(200);
	}
}
