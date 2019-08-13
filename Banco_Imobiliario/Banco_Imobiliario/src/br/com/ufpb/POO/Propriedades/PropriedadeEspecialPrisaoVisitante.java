package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo PropriedadeEspecialPrisaoVisitante
 */
import br.com.ufpb.POO.Jogador;

public class PropriedadeEspecialPrisaoVisitante extends PropriedadeEspecial {

	//Construtor
	public PropriedadeEspecialPrisaoVisitante(String nome, int indice) {
		super(nome, indice);
	}
	
	/** Método que permite o jogador não pagar imposto de renda
	 *  @param jogador Jogador - Jogador que não vai pagar o imposto 
	 */
	public void funcaoTabuleiro(Jogador jogador) {
		System.out.println("Nada aconteceu.");
	}

}
