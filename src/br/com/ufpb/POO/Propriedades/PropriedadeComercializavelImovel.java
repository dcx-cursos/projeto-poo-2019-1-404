package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo PropriedadeComercializavelImovel, onde serão contidos, valores e m�todos para os mesmos.
 */

import java.util.Scanner;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Verificadores.VerificadoresDojogo;

public class PropriedadeComercializavelImovel extends PropriedadeComercializavel {
	
	private int contCasas = 0;
	private Scanner scan;
	private VerificadoresDojogo verificador = new VerificadoresDojogo();
	//Construtor
	public PropriedadeComercializavelImovel(String nome, String cor_regiao, int valor, int taxa, int taxa1, int taxa2, int taxa3,
			int taxa4, int valorHotel, int valorCasa, int mult, int id) {
		super(nome, cor_regiao, valor, taxa, taxa1, taxa2, taxa3, taxa4, valorHotel, valorCasa, mult, id);
		this.scan = new Scanner(System.in);
	}
	
	public int getContCasas() {
		return contCasas;
	}
	
	public void setContCasas(int number)
	{
		this.contCasas += number;
	}
	
	/** M�todo para comprar a propriedade verificando se ela já está vendida
	 *  @param jogador Jogador - Comprador
	 */
	public void funcaoTabuleiro(Jogador jogador) {
		if(!this.estaVendido()) {
			System.out.println("O t�tulo da propriedade "+ this.getNome()+" est� disponível por $"+this.getValor()+".");
			System.out.println(""+jogador.getNome()+" você possui $"+jogador.getSaldo()+".");
			System.out.print("Você deseja comprar "+this.getNome()+" (Sim/N�o)? ");
			String resposta = this.scan.nextLine().toUpperCase();
			if(resposta.equals("S") || resposta.equals("SIM")) {
				if(verificador.podeComprar(jogador, this)) {
				jogador.comprar(this);
				System.out.println("Seu novo saldo é: $"+jogador.getSaldo());
				}else if(!verificador.podeComprar(jogador, this)) {
					System.out.println("Saldo insuficiente");
				}
			}
		}
		
		else {
			if(!this.getProprietario().equals(jogador)) {
				System.out.println("A propriedade já est� vendida, "+jogador.getNome()+" paga $"+this.getTaxa()+".");
				jogador.pagarTaxa(this.getTaxa());
				this.getProprietario().receberTaxa(this.getTaxa());
				System.out.println(""+this.getProprietario().getNome()+" recebe $"+this.getTaxa());
				System.out.println("Seu novo saldo é: $"+jogador.getSaldo());
			} else {
				System.out.print("A propriedade já é sua!\n");
			}
		}
	}

}