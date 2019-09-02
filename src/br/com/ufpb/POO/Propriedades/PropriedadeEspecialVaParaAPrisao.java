package br.com.ufpb.POO.Propriedades;
import java.util.Scanner;

/** Classe para objetos do tipo PropriedadeEspecialParaAPrisao
 */
import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public class PropriedadeEspecialVaParaAPrisao extends PropriedadeEspecial {
	private Listas lista;
	private Scanner scan;

	//Construtor
	public PropriedadeEspecialVaParaAPrisao(String nome, int indice, Listas lista) {
		super(nome, indice);
		this.lista = lista;
		this.scan = new Scanner(System.in);
	}
	
	/** AINDA SERÃ� IMPLEMENTADO
	 * @param jogador Jogador 
	 */
	public void funcaoTabuleiro(Jogador jogador) {
		CasaDoTabuleiro prisao = lista.getTabuleiro().get(30);
		mover(jogador, prisao);
		lista.addJogadorPreso(jogador);
		System.out.print(""+jogador.getNome()+" está preso!\n");
		System.out.println("Utilizar: [HABEAS CORPUS] [FIANCA] *Fiança custa R$50");
		String escolha = this.scan.nextLine().toUpperCase();
		if(escolha.equals("HABEAS CORPUS"))
		{
			if(jogador.getTemHabeas())
			{
				lista.setJogadoresPresos(jogador);
				jogador.setUsouHabeas(true);
				jogador.setTemHabeas(false);
				System.out.println(""+jogador.getNome()+" está livre!\n");
				if(jogador.getUsouHabeas())
				{
					jogador.setUsouHabeas(false);
					this.lista.getDeck().insereCartaHabeas();
				}
			}
			else
			{
				System.out.println(""+jogador.getNome()+" vocÃª nÃ£o possui o Habeas Corpus, tente novamente.");
				funcaoTabuleiro(jogador);
			}
		}
		if(escolha.equals("FIANCA"))
		{
			jogador.pagarTaxa(50);
			System.out.println(""+jogador.getNome()+" está livre!\n");
		}
		else
		{
			System.out.println("Resposta Inválida, tente novamente.");
			funcaoTabuleiro(jogador);
		}
	}

}
