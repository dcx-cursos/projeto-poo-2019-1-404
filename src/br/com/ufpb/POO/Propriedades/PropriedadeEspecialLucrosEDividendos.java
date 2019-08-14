package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo PropriedadeEspecialLucrosEDividendos
 */

import br.com.ufpb.POO.Jogador;

public class PropriedadeEspecialLucrosEDividendos extends PropriedadeEspecial {

	//Construtor
	public PropriedadeEspecialLucrosEDividendos(String nome, int indice) {
		super(nome, indice);
	}
	
	/** Método para que o jogador pague o imposto de renda
	 *  @param jogador Jogador - Jogador que pagará o imposto
	 */
	public void funcaoTabuleiro(Jogador jogador) {
		jogador.receberTaxa(200);
		System.out.println(""+jogador.getNome()+" recebe $200.");
		System.out.println("Seu novo saldo é: $"+jogador.getSaldo());
	}

}
