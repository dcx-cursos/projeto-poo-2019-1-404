package br.com.ufpb.POO.Tests;
/* Classe de testes para objetos do tipo VerificadoresDojogoTest.*/

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
	
	/* Inicialização dos objetos jogador,propriedade comercializavel,dados e do verificador do jogo.
	 */
	@Before
	public void iniciaObjetos() {
	jogador = new Jogador("Josué", "azul", new CasaDoTabuleiro(), 1000);
	verificador = new VerificadoresDojogo();
	propriedades = new PropriedadeComercializavel("nome","cor_regiao",100,10,10,10,10,10,10,10,10,10);
	dados = new Dados();
	listas = Listas.getInstance();
	insereJogadores = new InsereJogadores();
	insereJogadores.iniciarCores();
	}
	
	
	
	/* Teste responsavel por verificar o comportamento do metodo "PossuiSaldo".
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
	
	/* Teste para verificar o comportamento do método valorValido.
	 * Verifica se os valores 'a','#','0','1','9' e '-3' são valores válidos. Para essas verificações espera-se valores 'false'. 
	 * Depois verifica se os valores '2','5' e '8' são válidos. Espera-se um valor 'false'.
	 */
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
	
	/* Testa o comportamento do método corExiste.
	 * Inicia as cores.
	 * Verifica se existe cor com o valor " ". Espera-se um valor false.
	 * Verifica se existe cor com o valor '1'. Espera-se um valor false para essa verificação.
	 * Verifica se existe cor com o valor "branco". Espera-se um valor true.
	 * Verifica se existe cor com o valor "cinza". Espera-se um valor false.
	 */
	@Test
	public void testCorExiste() {
		insereJogadores.iniciarCores();
		assertFalse(verificador.corExiste("", insereJogadores.getCores()));
		assertFalse(verificador.corExiste("1", insereJogadores.getCores()));
		assertTrue(verificador.corExiste("branco", insereJogadores.getCores()));
		assertFalse(verificador.corExiste("cinza", insereJogadores.getCores()));
	}
	
	/* Testa a funcionalidade do método nomeisValido.
	 * Verifica se o nome "Josué" é válido (se não existe na lista de jogadores). Espera-se um valor true para essa varificação.
	 * Verifica se o nome " " (vazio) está na lista de jogadores. Espera-se um valor false.
	 * Adiciona um jogador com nome "Josué".
	 * Verifica se o nome "Josué" é válido (se não existe na lista de jogadores) para ser cadastrado. Espera-se um valor false.
	 */
	@Test
	public void testNomeisValido() {
		assertTrue(verificador.nomeIsValido("Josué",listas.getJogadores()));
		assertFalse(verificador.nomeIsValido(" ",listas.getJogadores()));
		listas.addJogador(jogador);
		assertFalse(verificador.nomeIsValido("Josué",listas.getJogadores()));
	}
}
