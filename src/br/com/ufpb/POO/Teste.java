package br.com.ufpb.POO;

/**Classe para realizar a inicialização do Jogo, onde serão contidos, valores e métodos.
 * @author Anderson, Ismar, Jobson, Josué
 */

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.*;

public class Teste {

	/**Main de inicialização do Jogo*/

    public static void main(String[] args) {
    	ControlesTabuleiro controles = new ControlesTabuleiro();
    	Listas lista = new Listas();
    	Tabuleiro tabuleiro = new Tabuleiro(lista);
    	
    }
}
