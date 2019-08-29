package br.com.ufpb.POO.Verificadores;

import br.com.ufpb.POO.Dados;
import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavel;

public class VerificadoresDojogo {
	
	
	//Metodo responsavel por verificar se o jogador possui saldo
	public boolean possuiSaldo(Jogador jogador) {
		if (jogador.getSaldo()>=0) {
			return true;
		}
		return false;
		}
	
	
	//Método responsavel por verificar se o jogador possui saldo necessario para comprar uma propriedade comercializavel
	public boolean podeComprar(Jogador jogador, PropriedadeComercializavel propriedade) {
		if(propriedade.getValor()<jogador.getSaldo()) {
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