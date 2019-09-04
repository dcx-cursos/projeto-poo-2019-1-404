package br.com.ufpb.POO.Tests;
/* Classe de testes para objetos do tipo CasaDoTabuleiro.*/

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;
import br.com.ufpb.POO.Tabuleiro;
import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;

public class CasaDoTabuleiroTest {
	public Listas lista;
	public Tabuleiro tabuleiro;
	public Jogador jogador1;
	
	/* Inicia os objetos do tipo Listas, Tabuleiro e Jogador.*/
	@Before
	public void  iniciaObjetos() {
		lista = new Listas();
		tabuleiro = new Tabuleiro(lista);
		jogador1 = new Jogador("Ismar", "Azul",lista.getTabuleiro().get(0),1500);		
	}
	
	/* Testa a movimentação do jogador.
	 * Adiciona o jogador na lista de jogadores ativos.
	 * Verifica se o jogador está na casa do tabuleiro.
	 */
	@Test
	public void testMover() {
		lista.addJogador(jogador1);
		lista.addListaDeJogadoresNaCasaDePartida();
		jogador1.getPos().mover(jogador1, lista.getTabuleiro().get(7));
		assertTrue(lista.getTabuleiro().get(7).getJogadoresNaCasa().get(0)==jogador1);
		assertFalse(lista.getTabuleiro().get(0).getJogadoresNaCasa().contains(jogador1));
	}

}
