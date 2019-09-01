package br.com.ufpb.POO.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.ufpb.POO.Dados;
import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavel;
import br.com.ufpb.POO.Verificadores.VerificadoresDojogo;

public class VerificadoresDojogoTest {
	public Jogador jogador;
	public VerificadoresDojogo verificador;
	public PropriedadeComercializavel propriedades;
	public Dados dados;
	
	//Inicialização dos objetos jogador,propriedade comercializavel,dados e do verificador do jogo.
	@Before
	public void iniciaObjetos() {
	jogador = new Jogador("Josué", "azul", new CasaDoTabuleiro(), 1000);
	verificador = new VerificadoresDojogo();
	propriedades = new PropriedadeComercializavel("nome","cor_regiao",100,10,10,10,10,10,10,10,10,10);
	dados = new Dados();
	}
	
	
	
	/*Teste responsavel por verificar o comportamento do metodo "PossuiSaldo".
	 * No primeiro caso espera-se um retorno false pelo fato do jogador não possuir saldo positivo.
	 * No segundo caso espera-se um retorno true pelo fato do jogador ter um saldo positivo
	 * No terceiro caso espera-se um retorno true pelo fato do jogador possuir um saldo igual a zero
	*/
	@Test
	public void testPossuiSaldo() {
		jogador.setSaldo(-200);
		assertFalse(verificador.possuiSaldo(jogador));
		jogador.setSaldo(1000);
		assertTrue(verificador.possuiSaldo(jogador));
		jogador.setSaldo(0);
		assertTrue(verificador.possuiSaldo(jogador));
	}
	
	
	
	
	/*Teste responsavel por verificar o comportamento do metodo "PodeComprar".
	 * No primeiro caso espera-se um retorno false pelo fato do jogador  possuir saldo inferior ao valor da propriedade.
	 * No segundo caso espera-se um retorno true pelo fato do jogador ter um saldo maior que o valor da propriedade.
	 * No terceiro caso espera-se um retorno true pelo fato do jogador possuir um saldo igual a zero, sendo assim incapaz de realizar a compra.
	*/
	@Test
	public void testPodeComprar() {
		jogador.setSaldo(10);
		assertFalse(verificador.podeComprar(jogador, propriedades));
		jogador.setSaldo(1000);
		assertTrue(verificador.podeComprar(jogador, propriedades));
		jogador.setSaldo(0);
		assertFalse(verificador.podeComprar(jogador, propriedades));
	}
	
	
	
	
	/*Teste responsavel por verificar o comportamento do metodo "Lancar Dados".
	 * No caso espera-se um retorno true pelo fato do resultado dos dados ser >= 1 ou <=12
	*/
	@Test
	public void testResultadoDosDados() {
		dados.lancarDados();
		System.out.println(dados.resultado());
		assertTrue(verificador.ResultadoDosDados(dados));
	}

}
