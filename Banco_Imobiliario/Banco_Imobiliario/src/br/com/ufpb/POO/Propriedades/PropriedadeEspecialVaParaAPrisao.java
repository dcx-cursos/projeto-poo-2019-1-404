package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo PropriedadeEspecialParaAPrisao
 */
import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public class PropriedadeEspecialVaParaAPrisao extends PropriedadeEspecial {
	private Listas lista;

	//Construtor
	public PropriedadeEspecialVaParaAPrisao(String nome, int indice) {
		super(nome, indice);
	}
	
	/** AINDA SERÁ IMPLEMENTADO
	 * @param jogador Jogador 
	 */
	public void funcaoTabuleiro(Jogador jogador) {
//		CasaDoTabuleiro prisao = lista.getTabuleiro().get(30);
//		mover(jogador, prisao);
//		lista.addJogadorPreso(jogador);
//		System.out.print(""+jogador.getNome()+" está preso!");
		System.out.println("Por enquanto, nada aconteceu.");
	}

}
