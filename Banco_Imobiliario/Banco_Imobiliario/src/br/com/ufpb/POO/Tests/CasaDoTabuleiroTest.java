package br.com.ufpb.POO.Tests;

/**Classe de Testes dos Métodos da classe CasaDoTabuleiro
*/

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;
import br.com.ufpb.POO.Tabuleiro;
import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;

public class CasaDoTabuleiroTest {

    /**Teste do método mover()
    */

	@Test
	public void testMover() {
		Listas lista = new Listas();
		Tabuleiro tabuleiro = new Tabuleiro(lista);
		Jogador jogador1 = new Jogador("Ismar", "Azul",lista.getTabuleiro().get(0),1500);
		lista.addJogador(jogador1);
		lista.addListaDeJogadoresNaCasaDePartida();
		jogador1.getPos().mover(jogador1, lista.getTabuleiro().get(7));
		//Passo 1
		assertTrue(lista.getTabuleiro().get(7).getJogadoresNaCasa().get(0)==jogador1);
		//Passo 2
		assertFalse(lista.getTabuleiro().get(0).getJogadoresNaCasa().contains(jogador1));
	}

}
