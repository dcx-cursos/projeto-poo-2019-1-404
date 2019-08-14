package br.com.ufpb.POO;

/**Classe para objetos do tipo ObterproxId, onde serão contidos, valores e métodos para o mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

import java.util.ArrayList;

public class ObterProxId {
	
	private Listas lista = new Listas();
	private Tabuleiro tabuleiro = new Tabuleiro(this.lista);
	
	/**Método para obter o Id da próxima casa, a qual o jogador irá chegar
	 * @param int - Id atual do Jogador
	 * @param int - resultado da soma dos valores dos dados
	 * @param Jogador - Jogador da vez
	 * @return int - Id da próxima casa*/

	public int obterIdProxCasa(int idAtual, int resultado, Jogador jogadorDaVez) {
		int idProxCasa, temp = 0;
		idProxCasa = idAtual + resultado;
		if(idProxCasa > 39) {
			this.lista.getTabuleiro().get(0).funcaoTabuleiro(jogadorDaVez);
			temp = idProxCasa % 40;
			idProxCasa = temp;
		}
		return idProxCasa;
	}
	
	/**Método para obter o Id do próximo Jogador da vez do jogo
	 * @param int - Id do Jogador
	 * @param ArrayList<Jogador> - lista de jogadores
	 * @return int - próximo id do Jogador da vez
	 */

	public int obterIdProxJogador(int idJogador, ArrayList<Jogador> jogadores) {
		int idProxJogador = 0, temp = 0;
		idProxJogador = idJogador + 1;
		if(idProxJogador > jogadores.size() - 1) {
			temp = idProxJogador % jogadores.size();
			idProxJogador = temp;
		}
		return idProxJogador;
	}
}
