package br.com.ufpb.POO.SorteReves;

import java.util.LinkedList;
import java.util.List;

public class PilhaCartas {

  private List<SorteRevesAbs> cartas = new LinkedList<SorteRevesAbs>();

  public PilhaCartas()
  {
	  criarDeck();
  }
  
  public void insereFinal(SorteRevesAbs carta)
  {
	  this.cartas.add(carta);
  }
  
  public void insereInicio(SorteRevesAbs objeto) {
    this.cartas.add(0, objeto);
  }

  public SorteRevesAbs remove() {
    return this.cartas.remove(this.cartas.size() - 1);
  }

  public boolean vazia() {
	  return this.cartas.size() == 0;
  }
  
  private void criarDeck()
  {
	  insereFinal(new SorteReves1());
	  insereFinal(new SorteReves2());
	  insereFinal(new SorteReves3());
  }
  
  public void desinfileirar()
  {
	  SorteRevesAbs cartaHabeas = null;
	  SorteRevesAbs temp = retirarCarta();
	  if(temp.getNumber() == 5)
	  {
		  cartaHabeas = temp;
		  temp = null;
	  }
	  else if(temp.getNumber() != 5){
		  insereInicio(temp);
	  }		  
  }
  
  public SorteRevesAbs retirarCarta()
  {
	 return remove();
  }
  
  public List<SorteRevesAbs> getLista()
  {
	  return this.cartas;
  }
  
  public static void main(String[] args)
  {
	  PilhaCartas p = new PilhaCartas();
	  for(SorteRevesAbs s: p.cartas)
	  {
		  System.out.println(s.getNumber());
	  }
	  System.out.println("---");
	  p.desinfileirar();
	  for(SorteRevesAbs s: p.cartas)
	  {
		  System.out.println(s.getNumber());
	  }		  
  }
}
