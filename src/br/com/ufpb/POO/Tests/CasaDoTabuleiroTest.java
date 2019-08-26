package br.com.ufpb.POO.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;
import br.com.ufpb.POO.Tabuleiro;
import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;

public class CasaDoTabuleiroTest {

	@Test
	public void testMover() {
		Listas lista = new Listas();
		Tabuleiro tabuleiro = new Tabuleiro(lista);
		Jogador jogador1 = new Jogador("Ismar", "Azul",lista.getTabuleiro().get(0),1500);
		lista.addJogador(jogador1);
		lista.addListaDeJogadoresNaCasaDePartida();
		jogador1.getPos().mover(jogador1, lista.getTabuleiro().get(7));
		assertTrue(lista.getTabuleiro().get(7).getJogadoresNaCasa().get(0)==jogador1);
		assertFalse(lista.getTabuleiro().get(0).getJogadoresNaCasa().contains(jogador1));
	}

}
