package br.com.ufpb.POO.Tests;
/* Classe de testes para objetos do tipo Listas.*/

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;
import br.com.ufpb.POO.Tabuleiro;
import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.Propriedades.PontoDePartida;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavel;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavelImovel;

public class ListasTest {
	public Listas lista;
	public Tabuleiro tabuleiro;
	public Jogador jogador1;
	public Jogador jogador2;
	public Jogador jogador3;
	public Jogador jogador4;
	
	/* Inicializa os objetos do tipo Jogador, Listas e Tabuleiro.
	 */
	@Before
	public void inciaObjetos() {
		lista = Listas.getInstance();
		tabuleiro = Tabuleiro.getInstance();
		jogador1 = new Jogador("Ismar", "Azul",lista.getTabuleiro().get(0),1500);
		jogador1.setId(0);
		jogador2 = new Jogador("Anderson", "Preto", lista.getTabuleiro().get(6), 1500);
		jogador2.setId(1);
		jogador3 = new Jogador("Jobson", "Verde", lista.getTabuleiro().get(1), 1500);
		jogador4 = new Jogador("Josu�", "Vermelho", lista.getTabuleiro().get(2), 1500);
		
	}
	
	/* Testa o comportamento do método addJogador.
	 * Adiciona 2 jogadores na lista de jogadores ativos.
	 * Verifica se os jogadores está na lista.
	 * Verifica se o tamanho da lista é igual ao numero de jogadores.
	 */
	@Test
	public void testAddJogador() {
		lista.addJogador(jogador1);
		assertEquals(lista.getJogadores().get(0),jogador1);
		assertEquals(1,lista.getJogadores().size());
		lista.addJogador(jogador2);
		assertEquals(lista.getJogadores().get(1),jogador2);
		assertEquals(2,lista.getJogadores().size());
    }
	
	/* Testa a funcionalidade do método addListaDeJogadoresNaCasaDePartida.
	 * Adiciona jogadores na lista de jogadores da casa inicial.
	 * Verifica se os jogadores estão na casa de partida.
	 */
	@Test
	public void testAddListaDeJogadoresNaCasaDePartida(){
		lista.addJogador(jogador1);
		lista.addJogador(jogador2);
		lista.addJogador(jogador4);
		lista.addListaDeJogadoresNaCasaDePartida();
		//Parte 1
		assertTrue(lista.getJogadoresJogando().contains(jogador1));
		assertTrue(lista.getJogadoresJogando().contains(jogador2));
		assertFalse(lista.getJogadoresJogando().contains(jogador3));
		assertTrue(lista.getJogadoresJogando().contains(jogador4));
		//Parte 2
		assertEquals(lista.getTabuleiro().get(0),jogador1.getPos());
		assertFalse(lista.getTabuleiro().get(6).getJogadoresNaCasa().contains(jogador2));
		assertEquals(lista.getTabuleiro().get(6),jogador2.getPos());
		assertEquals(lista.getTabuleiro().get(2),jogador4.getPos());
		assertEquals(lista.getTabuleiro().get(0).getJogadoresNaCasa().get(0),jogador1);
		assertEquals(3,lista.getTabuleiro().get(0).getJogadoresNaCasa().size());
		
	}
}