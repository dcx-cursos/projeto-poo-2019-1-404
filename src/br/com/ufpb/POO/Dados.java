package br.com.ufpb.POO;
/**Classe para objetos do tipo Dados, onde serão contidos, valores e métodos para o mesmo.
 *@author Anderson, Ismar, Jobson, Josué
 */


import java.util.Random;

public class Dados {

	Random lancamento = new Random();
	int dado1;
	int dado2;
	
	/** Método para lançar dois dados de valores aleatórios.
	 */
	public void lancarDados() {
		dado1 = lancamento.nextInt(6)+1;
		dado2 = lancamento.nextInt(6)+1;
	}
	
	/** Método para mostrar o resultado do lançamento dos dados.
	 * @return int
	 */
	public int resultado() {
		return this.dado1+this.dado2;
	}
	
	/** Método para obter o valor do dado 1.
	 * 
	 * @return int
	 */
	public int getDado1() {
		return this.dado1;
	}
	
	/** Método para obter o valor do dado 2.
	 * 
	 * @return int
	 */
	public int getDado2() {
		return this.dado2;
	}
}