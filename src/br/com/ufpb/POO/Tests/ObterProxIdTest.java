package br.com.ufpb.POO.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;
import br.com.ufpb.POO.ObterProxId;
import br.com.ufpb.POO.Tabuleiro;


public class ObterProxIdTest {
	public ObterProxId obterProxId;
	public Listas lista;
	public Tabuleiro tabuleiro;
	public Jogador jogador1;
	public Jogador jogador2;
	public Jogador jogador3;
	
	@Before
	public void iniciaObjetos(){
		obterProxId = new ObterProxId();
		lista = new Listas();
		tabuleiro = new Tabuleiro(lista);
		jogador1 = new Jogador("Anderson", "Preto",lista.getTabuleiro().get(0),1500);
		jogador2 = new Jogador("Ismar", "Azul", lista.getTabuleiro().get(6), 1500);
		jogador3 = new Jogador("Josué", "Vermelho", lista.getTabuleiro().get(1), 1500);
		
	}
	@Test
	public void testObterIdProxCasa() {
		lista.addJogador(jogador1);
		lista.addListaDeJogadoresNaCasaDePartida();
		jogador1.getPos().mover(jogador1, lista.getTabuleiro().get(6));
		//Passo 1
		int proxId = obterProxId.obterIdProxCasa(jogador1.getPos().getIndice(),7,jogador1);
		assertEquals(13,proxId);
		jogador1.getPos().mover(jogador1, lista.getTabuleiro().get(13));
		int proxId2 = obterProxId.obterIdProxCasa(jogador1.getPos().getIndice(),12,jogador1);
		assertEquals(25,proxId2);
		jogador1.getPos().mover(jogador1, lista.getTabuleiro().get(25));
		int proxId3 = obterProxId.obterIdProxCasa(jogador1.getPos().getIndice(),5,jogador1);
		assertEquals(30,proxId3);
		jogador1.getPos().mover(jogador1, lista.getTabuleiro().get(30));
		int proxId4 = obterProxId.obterIdProxCasa(jogador1.getPos().getIndice(),10,jogador1);
		assertEquals(0,proxId4);	
	}
	@Test
	public void testObterProxJogador() {
		lista.addJogadorJogando(jogador1);
		lista.addJogadorJogando(jogador2);
		lista.addJogadorJogando(jogador3);
		//Passo 1
		assertEquals(1,obterProxId.obterIdProxJogador(jogador1.getId(), lista.getJogadoresJogando()));
		assertEquals(2,obterProxId.obterIdProxJogador(jogador2.getId(), lista.getJogadoresJogando()));
		assertEquals(0,obterProxId.obterIdProxJogador(jogador3.getId(), lista.getJogadoresJogando()));
		
	}

}
