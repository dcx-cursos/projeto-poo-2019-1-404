package br.com.ufpb.POO.Tests;
/* Classe de testes para objetos do tipo Jogador.*/

import static org.junit.Assert.*;

import java.util.ConcurrentModificationException;

import org.junit.Test;

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.Propriedades.Ponto_de_Partida;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavel;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavelEmpresa;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavelImovel;
import br.com.ufpb.POO.*;
public class JogadorTest {

	/* Testa o comportamento do método getPos.
	 * Cria um objeto do tipo CasaDoTabuleiro e outro do tipo Jogador.
	 * Depois verifica se a posição do jogador é igual a da casa do tabuleiro.
	 */
	@Test
	public void testGetPos() {
		CasaDoTabuleiro casa = new PropriedadeComercializavelImovel("Leblon", "lilás",100,6,30,90,270,400,500,50,0,1);
		Jogador jogador = new Jogador("Ismar", "Azul", casa, 1500);
        assertEquals(casa,jogador.getPos());
    }
	
	/* Testa a funcionalidade do método comprar.
	 * Cria objetos dos tipos CasaDoTabuleiro, PropriedadeComercializavel e Jogador.
	 * Depois verifica se o nome do proprietario é igual a "Ismar".
	 * Verifica se a propriedade esta vendida, espera-se como resultado o valor true.
	 * Verifica se o jogador possui a propriedade, espera-se como resultado o valor true.
	 * Em seguida verifica se o valor foi debitado do saldo do jogador, espera-se como resultado o valor true.
	 */
	@Test
	public void testComprar(){
		CasaDoTabuleiro casa = new Ponto_de_Partida("Ponto de Partida", 0);
		PropriedadeComercializavel propriedade = new PropriedadeComercializavelImovel("Leblon", "lilás",100,6,30,90,270,400,500,50,0,1);
		Jogador jogador = new Jogador("Ismar", "Azul", casa, 1500);
		jogador.comprar(propriedade);
		assertEquals("Ismar",propriedade.getProprietario().getNome());
		assertTrue(propriedade.estaVendido());
		assertTrue(jogador.getMinhasPropriedades().contains(propriedade));
		assertTrue(jogador.getSaldo()==1500-propriedade.getValor());	
	}
	
	/*  Testa o comportamento do método setMinhasPropriedades que pode ocorrer uma exceção do tipo ConcurrentModificationException.
	 * 	Cria objetos dos tipos Jogador e PropriedadeComercializavel.
	 *  Adiciona 3 propriedades na lista de propriedades do jogador.
	 *  Verifica se as propriedades são do jogador, sendo esperado dois valores false e um true.
	 */
	@Test(expected=ConcurrentModificationException.class)
	public void testSetMinhasPropriedades(){
		PropriedadeComercializavel lilas = new PropriedadeComercializavelImovel("Av. Presidente Vargas", "lilÃ¡s", 60 , 2, 10, 30, 90, 160, 250, 50, 0, 3);
		Jogador jogador = new Jogador("Ismar", "Azul", lilas, 1500);
		jogador.addPropriedade(lilas);
		PropriedadeComercializavel lilas2 = new PropriedadeComercializavelImovel("Av. Nossa Senhora De Copacabana", "lilÃ¡s", 60 ,2, 10, 30, 90, 160, 250, 50, 0, 4);
		jogador.addPropriedade(lilas2);
		PropriedadeComercializavel lilas3 = new PropriedadeComercializavelEmpresa("Companhia De Viacao", "", 200 , 0, 0, 0, 0, 0, 0, 0, 50, 7);
		jogador.addPropriedade(lilas3);
		jogador.setMinhasPropriedades(lilas);
		jogador.setMinhasPropriedades(lilas3);
		assertTrue(jogador.getMinhasPropriedades().contains(lilas3));
		assertFalse(jogador.getMinhasPropriedades().contains(lilas));
		assertFalse(jogador.getMinhasPropriedades().contains(lilas3));
	}
	
	/* Testa a funcionalidade do método toStatus.
	 * Cria 3 objetos do tipo PropriedadeComercializavel e um do tipo Jogador.
	 * Adiciona as 3 propriedades a lista de propriedades do jogador.
	 * Verifica se o status do jogador é igual ao valor esperado.
	 */
	@Test
	public void testToStatus(){
		PropriedadeComercializavel lilas = new PropriedadeComercializavelImovel("Av. Presidente Vargas", "lilÃ¡s", 60 , 2, 10, 30, 90, 160, 250, 50, 0, 3);
		PropriedadeComercializavel lilas2 = new PropriedadeComercializavelImovel("Av. Nossa Senhora De Copacabana", "lilÃ¡s", 60 ,2, 10, 30, 90, 160, 250, 50, 0, 4);
		PropriedadeComercializavel lilas3 = new PropriedadeComercializavelEmpresa("Companhia De Viacao", "", 200 , 0, 0, 0, 0, 0, 0, 0, 50, 7);
		Jogador jogador = new Jogador("Ismar", "Azul", lilas, 1500);
		jogador.addPropriedade(lilas);
		jogador.addPropriedade(lilas2);
		jogador.addPropriedade(lilas3);
		String status = jogador.toStatus();
		String titulos = "["+lilas.getNome()+"] - propriedade "+lilas.getCorRegiao()+", aluguel "+lilas.getTaxa()+"\n"+
						 "["+lilas2.getNome()+"] - propriedade "+lilas2.getCorRegiao()+", aluguel "+lilas2.getTaxa()+"\n"+
						 "["+lilas3.getNome()+"] - multiplicador de $"+lilas3.getMult()+"\n";
		String expectedStatus = "O status de "+jogador.getNome()+" - "+jogador.getCorPeao()+" é o seguinte:"
    			+ "\nSituado na posição "+jogador.getIdAtualDoJogador()+" - "+jogador.getPos().getNome()+""
				+ "\nPossui $"+jogador.getSaldo()+""
						+ "\nTítulos:"
						+ "\n"+titulos;
		assertEquals(expectedStatus,status);
	}
}