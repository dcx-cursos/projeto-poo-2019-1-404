package br.com.ufpb.POO;

/**Classe para objetos do tipo Tabuleiro, onde serão contidos, valores e métodos para o mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

import java.util.ArrayList;

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.Propriedades.PontodePartida;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavelEmpresa;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavelImovel;
import br.com.ufpb.POO.Propriedades.PropriedadeEspecialImpostoDeRenda;
import br.com.ufpb.POO.Propriedades.PropriedadeEspecialLucrosEDividendos;
import br.com.ufpb.POO.Propriedades.PropriedadeEspecialParadaLivre;
import br.com.ufpb.POO.Propriedades.PropriedadeEspecialPrisaoVisitante;
import br.com.ufpb.POO.Propriedades.PropriedadeEspecialSorteReves;
import br.com.ufpb.POO.Propriedades.PropriedadeEspecialVaParaAPrisao;

public class Tabuleiro {
	private static Tabuleiro instance;
	private ArrayList<CasaDoTabuleiro> tabuleiro;
	private Listas listas;
	
	private Tabuleiro() {
		this.listas = Listas.getInstance();
		this.tabuleiro = Listas.getInstance().getTabuleiro();
		criarCasasNoTabuleiro();
	}
	
    public static Tabuleiro getInstance()
    {
    	if(instance == null)
    	{
    		synchronized (Listas.class) {
    			if(instance == null) 
    			{
    				instance = new Tabuleiro();    				
    			}
			}
    	}
    	
    	return instance;
    }

	/**Método para adicionar a lista de Casas ao tabuleiro*/
	
	public void criarCasasNoTabuleiro() {
		tabuleiro.add(new PontodePartida("Ponto de Partida", 0));																			//POSICAO 00
		tabuleiro.add(new PropriedadeComercializavelImovel("Leblon", "lilás",100,6,30,90,270,400,500,50,0,1));										//POSICAO 01
		tabuleiro.add(new PropriedadeEspecialSorteReves("Sorte ou Reves", 2));																//POSICAO 02
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. Presidente Vargas", "lilás", 60 , 2, 10, 30, 90, 160, 250, 50, 0, 3));				//POSICAO 03
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. Nossa Senhora De Copacabana", "lilás", 60 ,2, 10, 30, 90, 160, 250, 50, 0, 4));		//POSICAO 04
		tabuleiro.add(new PropriedadeComercializavelEmpresa("Companhia Ferroviaria", "", 200 , 0, 0, 0, 0, 0, 0, 0, 50, 5));					//POSICAO 05
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. Brigadeiro Faria Lima", "celeste", 240 , 20, 100, 300, 750, 925, 1100, 150, 0, 6));	//POSICAO 06
		tabuleiro.add(new PropriedadeComercializavelEmpresa("Companhia De Viacao", "", 200 , 0, 0, 0, 0, 0, 0, 0, 50, 7));						//POSICAO 07
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. Reboucas", "celeste", 220, 18, 90, 250, 700, 875, 1050, 150, 0, 8));					//POSICAO 08
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. 9 De Julho", "celeste", 220, 18, 90, 250, 700, 875, 1050, 150, 0, 9));					//POSICAO 09
		tabuleiro.add(new PropriedadeEspecialPrisaoVisitante("Prisao (visitante)", 10));													//POSICAO 10
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. Europa", "roxo", 200 , 16, 80, 220, 600, 800, 1000, 100, 0, 11));					//POSICAO 11
		tabuleiro.add(new PropriedadeEspecialSorteReves("Sorte ou Reves", 12));																//POSICAO 12
		tabuleiro.add(new PropriedadeComercializavelImovel("Rua Augusta", "roxo", 180 , 14, 70, 200, 550, 750, 950, 100, 0, 13));					//POSICAO 13
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. Pacaembu", "roxo", 180 , 14, 70, 200, 550, 750, 950, 100, 0, 14));					//POSICAO 14
		tabuleiro.add(new PropriedadeComercializavelEmpresa("Companhia De Taxi", "", 150 , 0, 0, 0, 0, 0, 0, 0, 40, 15));						//POSICAO 15
		tabuleiro.add(new PropriedadeEspecialSorteReves("Sorte ou Reves", 16));																//POSICAO 16
		tabuleiro.add(new PropriedadeComercializavelImovel("Interlagos", "laranja", 350 , 35, 175, 500, 1100, 1300, 1500, 200, 0, 17));				//POSICAO 17
		tabuleiro.add(new PropriedadeEspecialLucrosEDividendos("Lucros E Dividendos", 18));													//POSICAO 18
		tabuleiro.add(new PropriedadeComercializavelImovel("Morumbi", "laranja", 400 , 50, 200, 600, 1400, 1700, 2000, 200, 0, 19));					//POSICAO 19
		tabuleiro.add(new PropriedadeEspecialParadaLivre("Parada Livre", 20));																//POSICAO 20
		tabuleiro.add(new PropriedadeComercializavelImovel("Flamengo", "vermelho", 120, 8, 40, 100, 300, 450, 600, 50, 0, 21));							//POSICAO 21
		tabuleiro.add(new PropriedadeEspecialSorteReves("Sorte ou Reves", 22));																//POSICAO 22
		tabuleiro.add(new PropriedadeComercializavelImovel("Botafogo", "vermelho", 100, 6, 30, 90, 270, 400, 500, 50, 0, 23));							//POSICAO 23
		tabuleiro.add(new PropriedadeEspecialImpostoDeRenda("Imposto De Renda", 24));														//POSICAO 24
		tabuleiro.add(new PropriedadeComercializavelEmpresa("Companhia De Navegacao", "", 150, 0, 0, 0, 0, 0, 0, 0, 40, 25));					//POSICAO 25
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. Brasil", "amarelo", 160, 12, 60, 180, 500, 700, 900, 100, 0, 26));					//POSICAO 26
		tabuleiro.add(new PropriedadeEspecialSorteReves("Sorte ou Reves", 27));																//POSICAO 27
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. Paulista", "amarelo", 140, 10, 50, 150, 450, 625, 750, 100, 0, 28));					//POSICAO 28
		tabuleiro.add(new PropriedadeComercializavelImovel("Jardim Europa", "amarelo", 140, 12, 60, 180, 500, 700, 900, 100, 0, 29));					//POSICAO 29
		tabuleiro.add(new PropriedadeEspecialVaParaAPrisao("Va Para A Prisao", 30, this.listas));														//POSICAO 30
		tabuleiro.add(new PropriedadeComercializavelImovel("Copacabana", "verde", 260, 22, 110, 330, 800, 975, 1150, 150, 0, 31));					//POSICAO 31
		tabuleiro.add(new PropriedadeComercializavelEmpresa("Companhia De Aviacao", "", 200, 0, 0, 0, 0, 0, 0, 0, 50, 32));						//POSICAO 32
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. Vieira Souto", "verde", 320, 28, 150, 450, 1000, 1200, 1400, 200, 0, 33));			//POSICAO 33
		tabuleiro.add(new PropriedadeComercializavelImovel("Av. Atlantica", "verde", 300, 26, 130, 390, 900, 1100, 1275, 200, 0, 34));				//POSICAO 34
		tabuleiro.add(new PropriedadeComercializavelEmpresa("Companhia Taxi Aereo", "", 200, 0, 0, 0, 0, 0, 0, 0, 50, 35));					//POSICAO 35
		tabuleiro.add(new PropriedadeComercializavelImovel("Ipanema", "verde", 300, 26, 130, 390, 900, 1100, 1275, 200, 0, 36));						//POSICAO 36
		tabuleiro.add(new PropriedadeEspecialSorteReves("Sorte ou Reves", 37));																//POSICAO 37
		tabuleiro.add(new PropriedadeComercializavelImovel("Jardim Paulista", "azul", 280, 24, 120, 360, 850, 1025, 1200, 150, 0, 38));				//POSICAO 38								
		tabuleiro.add(new PropriedadeComercializavelImovel("Brooklin", "azul", 260, 22, 110, 330, 800, 975, 1150, 150, 0, 39));						//POSICAO 39
	}
}
