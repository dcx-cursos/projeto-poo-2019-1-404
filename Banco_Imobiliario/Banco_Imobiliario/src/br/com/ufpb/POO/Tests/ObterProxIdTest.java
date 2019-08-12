package br.com.ufpb.POO.Tests;

/**Classe de testes dos métodos da classe obterProxId*/

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;
import br.com.ufpb.POO.ObterProxId;
import br.com.ufpb.POO.Tabuleiro;


public class ObterProxIdTest {
	
	ObterProxId obterProxId = new ObterProxId();
	Listas lista = new Listas();
	Tabuleiro tabuleiro = new Tabuleiro(lista);
	Jogador jogador = new Jogador("Anderson", "Preto",lista.getTabuleiro().get(0),1500);
	Jogador jogador2 = new Jogador("Ismar", "Azul", lista.getTabuleiro().get(6), 1500);
	Jogador jogador3 = new Jogador("Josué", "Vermelho", lista.getTabuleiro().get(1), 1500);
	
    /**Teste do método obterProxCasa()*/    

	@Test
	public void testObterIdProxCasa() {
		lista.addJogador(jogador);
		lista.addListaDeJogadoresNaCasaDePartida();
		jogador.getPos().mover(jogador, lista.getTabuleiro().get(6));
		//Passo 1
		int proxId = obterProxId.obterIdProxCasa(jogador.getPos().getIndice(),7,jogador);
		assertEquals(13,proxId);
		jogador.getPos().mover(jogador, lista.getTabuleiro().get(13));
		int proxId2 = obterProxId.obterIdProxCasa(jogador.getPos().getIndice(),12,jogador);
		assertEquals(25,proxId2);
		jogador.getPos().mover(jogador, lista.getTabuleiro().get(25));
		int proxId3 = obterProxId.obterIdProxCasa(jogador.getPos().getIndice(),5,jogador);
		assertEquals(30,proxId3);
		jogador.getPos().mover(jogador, lista.getTabuleiro().get(30));
		int proxId4 = obterProxId.obterIdProxCasa(jogador.getPos().getIndice(),10,jogador);
		assertEquals(0,proxId4);	
	}

    /**Teste do método obterProxJogador()*/

	@Test
	public void testObterProxJogador() {
		lista.addJogadorJogando(jogador);
		lista.addJogadorJogando(jogador2);
		lista.addJogadorJogando(jogador3);
		//Passo 1
		assertEquals(1,obterProxId.obterIdProxJogador(jogador.getId(), lista.getJogadoresJogando()));
		assertEquals(2,obterProxId.obterIdProxJogador(jogador2.getId(), lista.getJogadoresJogando()));
		assertEquals(0,obterProxId.obterIdProxJogador(jogador3.getId(), lista.getJogadoresJogando()));
		
	}

}
