package br.com.ufpb.POO.SorteReves;
/**Classe para objetos do tipo SorteReves, onde serão contido, valores e métodos do mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PilhaCartas {

  private List<SorteRevesAbs> cartas = new LinkedList<SorteRevesAbs>();
  private boolean cartaHabeasRetirada;
  
  /* Construtor
   */
  public PilhaCartas(){
	  criarDeck();
	  Collections.shuffle(this.cartas);
	  this.cartaHabeasRetirada = false;
  }
  
  /* Método para adicionar uma carta no final da pilha.
   * @param SorteRevesAbs - Carta para adicionar
   */
  public void insereFinal(SorteRevesAbs carta){
	  this.cartas.add(carta);
  }
  
  /* Método para adicionar uma carta no inicio da pilha.
   * @param SorteRevesAbs - Carta a ser adicionada
   */
  public void insereInicio(SorteRevesAbs objeto) {
    this.cartas.add(0, objeto);
  }
  
  /* Método para adicionar a carata Habeas Corpus
   * @param SorteRevesAbs - Carta Habeas Corpus a ser adicionada
   * 
   */
  public void insereCartaHabeas(){
	  this.cartas.add(0, new SorteReves5());
	  this.cartaHabeasRetirada = false;
  }
  /* Método para retirar uma carta da lista.
   * @return SorteRevesAbs
   */
  public SorteRevesAbs remove() {
    return this.cartas.remove(this.cartas.size() - 1);
  }
  
  /** Método para verificar se a lista está vazia.
   * 
   * @return boolean
   */
  public boolean vazia() {
	  return this.cartas.size() == 0;
  }
  
  /**Método para verificar se a carta Habeas Corpus foi retirada.
   * 
   * @return boolean
   */
  public boolean getCartaHabeasRetirada(){
	  return this.cartaHabeasRetirada;
  }
  
  /** Método para inesrir as cartas no deck.
   */
  private void criarDeck(){
	  
	  insereFinal(new SorteReves1());
	  insereFinal(new SorteReves2());
	  insereFinal(new SorteReves3());
	  insereFinal(new SorteReves4());
	  insereFinal(new SorteReves5());
	  insereFinal(new SorteReves6());
	  insereFinal(new SorteReves7());
	  insereFinal(new SorteReves8());
	  insereFinal(new SorteReves9());
	  insereFinal(new SorteReves10());
	  insereFinal(new SorteReves11());
	  insereFinal(new SorteReves13());
	  insereFinal(new SorteReves14());
	  insereFinal(new SorteReves15());
	  insereFinal(new SorteReves16());
	  insereFinal(new SorteReves17());
	  insereFinal(new SorteReves18());
	  insereFinal(new SorteReves19());
	  insereFinal(new SorteReves20());
	  insereFinal(new SorteReves21());
	  insereFinal(new SorteReves22());
	  insereFinal(new SorteReves23());
	  insereFinal(new SorteReves25());
	  insereFinal(new SorteReves26());
	  insereFinal(new SorteReves27());
	  insereFinal(new SorteReves28());
	  insereFinal(new SorteReves29());
	  insereFinal(new SorteReves30());
	  insereFinal(new SorteReves31());
  }
  
  /** Método responsável por desenfileirar as cartas 
   */
  public void desinfileirar(){
	  
	  SorteRevesAbs cartaHabeas = null;
	  SorteRevesAbs temp = retirarCarta();
	  if(temp.getNumber() == 5){
		  this.cartaHabeasRetirada = true;
		  cartaHabeas = temp;
		  temp = null;
	  }else if(temp.getNumber() != 5){
		  insereInicio(temp);
	  }		  
  }
  /** Método para retirar uma carta 
   * @return SorteRevesAbs
   */
  public SorteRevesAbs retirarCarta(){
	  
	 return remove();
  }
  
  /** Método para retornar uma lista de cartas
   * 
   * @return List<SorteRevesAbs>
   */
  public List<SorteRevesAbs> getLista(){
	  
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
