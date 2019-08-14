package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo PropriedadeEspecialParadaLivre
 */
import br.com.ufpb.POO.Jogador;

public class PropriedadeEspecialParadaLivre extends PropriedadeEspecial {

	//Construtor
	public PropriedadeEspecialParadaLivre(String nome, int indice) {
		super(nome, indice);
	}
	
	/** Método que permite o jogador não pagar imposto de renda
	 *  @param jogador Jogador - Jogador que não vai pagar o imposto 
	 */
	public void funcaoTabuleiro(Jogador jogador) {
		System.out.println("Nada aconteceu.");
	}

}
