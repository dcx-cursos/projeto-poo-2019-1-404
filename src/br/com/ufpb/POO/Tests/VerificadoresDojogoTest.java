package br.com.ufpb.POO.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.ufpb.POO.Dados;
import br.com.ufpb.POO.InsereJogadores;
import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;
import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavel;
import br.com.ufpb.POO.Verificadores.VerificadoresDojogo;

public class VerificadoresDojogoTest {
	public Jogador jogador;
	public VerificadoresDojogo verificador;
	public PropriedadeComercializavel propriedades;
	public Dados dados;
	public Listas listas;
	public InsereJogadores insereJogadores;
	//public List<String> cores = Arrays.asList("preto","branco","vermelho","verde","azul","amarelo","laranja","rosa"); ---Essa � uma lista imutavel.
	
	//Inicialização dos objetos jogador,propriedade comercializavel,dados e do verificador do jogo.
	@Before
	public void iniciaObjetos() {
	jogador = new Jogador("Josué", "azul", new CasaDoTabuleiro(), 1000);
	verificador = new VerificadoresDojogo();
	propriedades = new PropriedadeComercializavel("nome","cor_regiao",100,10,10,10,10,10,10,10,10,10);
	dados = new Dados();
	listas = new Listas();
	insereJogadores = new InsereJogadores(listas);
	insereJogadores.iniciarCores();
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
	
	@Test
	public void testPodeComprar() {
		jogador.setSaldo(10);
		assertTrue(verificador.podeComprar(jogador, propriedades));
		jogador.setSaldo(1000);
		assertFalse(verificador.podeComprar(jogador, propriedades));
	}
	
	@Test
	public void testResultadoDosDados() {
		dados.lancarDados();
		System.out.println(dados.resultado());
		assertTrue(verificador.ResultadoDosDados(dados));
	}
	@Test
	public void testValorisValido() {
		assertFalse(verificador.ValorisValido(""));
		assertFalse(verificador.ValorisValido("a"));
		assertFalse(verificador.ValorisValido("#"));
		assertFalse(verificador.ValorisValido("0"));
		assertFalse(verificador.ValorisValido("1"));
		assertFalse(verificador.ValorisValido("9"));
		assertFalse(verificador.ValorisValido("-3"));
		assertTrue(verificador.ValorisValido("2"));
		assertTrue(verificador.ValorisValido("5"));
		assertTrue(verificador.ValorisValido("8"));
	}
	@Test
	public void testCorExiste() {
		insereJogadores.iniciarCores();
		assertFalse(verificador.corExiste("", insereJogadores.getCores()));
		assertFalse(verificador.corExiste("1", insereJogadores.getCores()));
		assertTrue(verificador.corExiste("branco", insereJogadores.getCores()));
		assertFalse(verificador.corExiste("cinza", insereJogadores.getCores()));
	}
	@Test
	public void testNomeisValido() {
		assertTrue(verificador.nomeIsValido("Josu�",listas.getJogadores()));
		assertFalse(verificador.nomeIsValido(" ",listas.getJogadores()));
		listas.addJogador(jogador);
		assertFalse(verificador.nomeIsValido("Josu�",listas.getJogadores()));
	}
	@Test
	public void testComandoIsValido() {
		String[] One = {"JOGAR","STATUS", "SAIR"};
		assertFalse(verificador.ComandoIsValido("", One));
		assertFalse(verificador.ComandoIsValido(" ", One));
		assertFalse(verificador.ComandoIsValido("s", One));
		assertFalse(verificador.ComandoIsValido("$", One));
		assertFalse(verificador.ComandoIsValido("0", One));
		assertTrue(verificador.ComandoIsValido("JOGAR", One));
		assertTrue(verificador.ComandoIsValido("status", One));
		
	}

}
