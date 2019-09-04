package br.com.ufpb.POO.Tests;
/** Classe para realizar o suite de testes*/

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CasaDoTabuleiroTest.class, JogadorTest.class, ListasTest.class, ObterProxIdTest.class,
		VerificadoresDojogoTest.class })
public class TodosOsTestes {

}
