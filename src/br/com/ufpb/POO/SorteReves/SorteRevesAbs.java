package br.com.ufpb.POO.SorteReves;

import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

public abstract class SorteRevesAbs {
	
	private int numberCard;

	public String funcaoCarta(Jogador jogadorDaVez)
	{
		return "";
	}
	
	public String funcaoCarta(Listas lista)
	{
		return "";
	}
	
	public int getNumber()
	{
		return this.numberCard;
	}
	
	public void setNumber(int number)
	{
		this.numberCard = number;
	}
}
