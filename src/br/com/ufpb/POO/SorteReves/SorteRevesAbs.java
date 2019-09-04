package br.com.ufpb.POO.SorteReves;
/**Classe abstrata para objetos do tipo SorteRevesAbs, onde serão contido, valores e métodos do mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public abstract class SorteRevesAbs {
	
	private int numberCard;
	
	/** Método abstrato para a função de cada carta, com um parametro do tipo Jogador.
	 * 
	 * @param jogadorDaVez
	 * @return String
	 */
	public String funcaoCarta(Jogador jogadorDaVez)
	{
		return "";
	}
	/** Método abstrato para a função de cada carta, com um parametro do tipo Lista.
	 * @param lista
	 * @return String
	 */
	public String funcaoCarta(Listas lista)
	{
		return "";
	}
	
	/** Método abstrato para retornar o numero de cada carta.
	 * 
	 * @return int
	 */
	public int getNumber()
	{
		return this.numberCard;
	}
	
	/** Método abstrato para setar o numero de cada carta.
	 * 
	 * @param number
	 */
	public void setNumber(int number)
	{
		this.numberCard = number;
	}
	
	/** Método abstrato para a função de cada carta, que recebo dois parametros do tipo Jogador e Listas. 
	 * 
	 * @param jogadorDaVez
	 * @param lista
	 * @return String
	 */
	public String funcaoCarta(Jogador jogadorDaVez,Listas lista) {
		return "";
	}
}
