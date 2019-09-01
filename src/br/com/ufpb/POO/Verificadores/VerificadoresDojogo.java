package br.com.ufpb.POO.Verificadores;

import java.awt.List;
import java.util.ArrayList;

import br.com.ufpb.POO.Dados;
import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavel;

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
	public boolean ComandoIsValido(String comando, String[] Comandos) {
		//String[] One = {"JOGAR","STATUS", "SAIR"};
		for (String s: Comandos ) {
			if(s.equalsIgnoreCase(comando)) {
				return true;
			}
		}
		return false;
	}
	//Metodo responsavel por verificar se o jogador possui saldo
	public boolean possuiSaldo(Jogador jogador) {
		if (jogador.getSaldo()>=0) {
			return true;
		}
		return false;
		}
	
	
	//Método responsavel por verificar se o jogador possui saldo necessario para comprar uma propriedade comercializavel.
	public boolean podeComprar(Jogador jogador, PropriedadeComercializavel propriedade) {
		if(propriedade.getValor()>jogador.getSaldo()) {
			return false;
		}
		return true;
		
	}
	
	//Método responsavel por verificar se o resultado dos dados são válidos
	public boolean ResultadoDosDados(Dados dado) {		
		if (dado.resultado() <= 12 && dado.resultado() > 0) {
			return true;
		}
		return false;
	}
}