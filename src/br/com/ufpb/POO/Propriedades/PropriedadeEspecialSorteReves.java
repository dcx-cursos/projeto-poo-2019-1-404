package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo PropriedadeEspecialSorteReves
 */

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;
import br.com.ufpb.POO.SorteReves.SorteReves;

public class PropriedadeEspecialSorteReves extends PropriedadeEspecial {
	
	//Construtor
	public PropriedadeEspecialSorteReves(String nome, int indice) {
		super(nome, indice);
	}
	
	/** Realiza a função referente a carta recebida pelo jogador
	 * @param jogador Jogador 
	 */
	public void funcaoTabuleiro(Jogador jogador) {
		int cartaRetirada = Listas.getInstance().getDeck().remove();
		SorteReves.funcaoCarta(cartaRetirada, jogador);
		Listas.getInstance().getDeck().desinfileirar(cartaRetirada);
	}
	
}