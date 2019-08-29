package br.com.ufpb.POO;

import java.util.Random;

public class Dados {

	Random lancamento = new Random();
	int dado1;
	int dado2;
	
	public void lancarDados() {
		dado1 = lancamento.nextInt(6)+1;
		dado2 = lancamento.nextInt(6)+1;
	}
	
	public int resultado() {
		return this.dado1+this.dado2;
	}
	public int getDado1() {
		return this.dado1;
	}
	public int getDado2() {
		return this.dado2;
	}
}