package br.com.ufpb.POO.Verificadores;
/**Classe para objetos do tipo Verificadores, onde serão contido, valores e métodos do mesmo.
 */


import java.util.ArrayList;

import br.com.ufpb.POO.Dados;
import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavel;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavelImovel;

public class VerificadoresDojogo {
	
	/**Método para verificar se o valor é valido para inserir jogadores*/
	public boolean ValorisValido(String n) {
		try {
			int number = Integer.parseInt(n);
			if(number<2 ||number>8) {
				System.out.println("N�mero de jogadores indispon�vel.");
				return false;
			}
			return true;
		}catch(NumberFormatException e) {
			System.out.println("Este campo s� permite numeros.");
			return false;
		}
	}
	
	/**Método para verificar se a cor existe e se não é um número*/
	public boolean corExiste(String cor, ArrayList<String> cores) {
		try {
			int number = Integer.parseInt(cor);
			System.out.println("Digite uma palavra referente a cor");
			return false;
		}catch(NumberFormatException e) {
			if(cores.contains(cor)) {
				return true;
			}
			System.out.println("Digite uma cor V�lida");
			return false;
		}
		
	}
	
	/**Método para verifica se o nome não é um número ou se já é utilizado em jogadores*/
	public boolean nomeIsValido(String nome, ArrayList<Jogador> jogadores) {
		try {
			int temp = Integer.parseInt(nome);
			System.out.println("Digite um nome em vez de um n�mero");
			return false;
		}catch(NumberFormatException e) {
			for (Jogador j: jogadores) {
				if(j.getNome().equals(nome)){
					System.out.println("Esse nome j� foi usado");
					return false;
				}
			}
			if(nome.equals("")|| nome.equals(" ")) {
				System.out.println("Campo digitado em branco");
				return false;
			}
			return true;
		}
	}
	
	/**Método para verificar se um determinado comando é válido para uma ação a fazer*/
	public boolean verificadorPodeConstruir(Jogador jogador) {
		return jogador.PodeContruir();
	}
	
	public boolean verificadorPossuiSaldoParaConstruir(Jogador jogador) {
		int maiorValorCasa = 0;
		for(PropriedadeComercializavelImovel p: jogador.getPropriedadesConstruir())
		{
			if(p.getValorCasa() > maiorValorCasa) maiorValorCasa = p.getValorCasa();
		}
		return jogador.getSaldo() >= maiorValorCasa;
	}
	
	//Metodo responsavel por verificar se o jogador possui saldo
	public boolean possuiSaldo(Jogador jogador) {
		return jogador.getSaldo()>=0;
	}
	
	public boolean verificarQuantJogadores() {
		return Listas.getInstance().getJogadoresJogando().size() > 1;
	}
	
	//Método responsavel por verificar se o jogador possui saldo necessario para comprar uma propriedade comercializavel.
	public boolean podeComprar(Jogador jogador, PropriedadeComercializavel propriedade) {
		return propriedade.getValor()<=jogador.getSaldo();
	}
	
	public boolean verificadorJaTemHotel(Jogador jogador, int escolha) {
		return jogador.getPropriedadesConstruir().get(escolha - 1).getContCasas() == 5;
	}
	
	public boolean verificadorTemCasaParaVender(Jogador jogador, int escolha) {
		return jogador.getPropriedadesConstruir().get(escolha- 1).getContCasas() >= 1;
	}
	
	public int verificarComandoDigitado(String comando) {
		if(comando.equals("J") || comando.equals("JOGAR")) return 1;
		if(comando.equals("STATUS")) return 2;
		if(comando.equals("S") || comando.equals("SAIR")) return 3;
		if(comando.equals("CONSTRUIR")) return 4;
		if(comando.equals("VENDER")) return 5;
		else {
			return 0;
		}
	}
	
	//Método responsavel por verificar se o resultado dos dados são válidos
	public boolean ResultadoDosDados(Dados dado) {		
		return dado.resultado() <= 12 && dado.resultado() > 0;
	}
}