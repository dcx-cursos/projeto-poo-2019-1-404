package br.com.ufpb.POO.Interfaces;

/**Classe para interfaces do tipo ICasa_do_Tabuleiro, onde contém os métod que devem ser implementados
*/

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;

public interface ICasas_do_Tabuleiro {
    
    /**Métodos a serem implementados a quem utilizar esta interface
    */

	public void adicionarJogadoresNaListaDaCasa(Jogador jogador);
	public void removerJogadoresDaListaDaCasa(Jogador jogador);
	public void mover(Jogador jogador, CasaDoTabuleiro destino);
	abstract void funcaoTabuleiro(Jogador jogador);
}
