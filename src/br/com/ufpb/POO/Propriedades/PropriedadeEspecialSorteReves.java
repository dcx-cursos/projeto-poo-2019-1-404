package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo PropriedadeEspecialSorteReves
 */

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public class PropriedadeEspecialSorteReves extends PropriedadeEspecial {
	private Listas lista;
	
	//Construtor
	public PropriedadeEspecialSorteReves(String nome, int indice, Listas lista) {
		super(nome, indice);
		this.lista = lista;
	}
	
	/** AINDA SERÁ IMPLEMENTADO
	 * @param jogador Jogador 
	 */
	public void funcaoTabuleiro(Jogador jogador) {
//		System.out.print("Sorte ou Revés, "+jogador.getNome()+" nada acontece!\n");
		if(this.lista.getDeck().getLista().get(this.lista.getDeck().getLista().size() - 1).getNumber() == 2)
		{
			System.out.println(this.lista.getDeck().getLista().get(this.lista.getDeck().getLista().size() - 1).funcaoCarta(lista));
			this.lista.getDeck().desinfileirar();
		}
		
		else
		{
			System.out.println(this.lista.getDeck().getLista().get(this.lista.getDeck().getLista().size() - 1).funcaoCarta(jogador));
			this.lista.getDeck().desinfileirar();			
		}

	}
	
}
