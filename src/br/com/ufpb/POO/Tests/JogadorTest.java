package br.com.ufpb.POO.Tests;

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

	
	@Test
	public void testGetPos() {
		CasaDoTabuleiro casa = new PropriedadeComercializavelImovel("Leblon", "lilás",100,6,30,90,270,400,500,50,0,1);
		Jogador jogador = new Jogador("Ismar", "Azul", casa, 1500);
        assertEquals(casa,jogador.getPos());
    }
	
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