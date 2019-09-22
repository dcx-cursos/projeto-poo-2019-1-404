package br.com.ufpb.POO.SorteReves;
/**Classe para objetos do tipo SorteReves, onde serão contido, valores e métodos do mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PilhaCartas {

  private List<Integer> cartas = new LinkedList<Integer>();
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
  public void insereFinal(int carta){
	  this.cartas.add(carta);
  }
  
  /* Método para adicionar uma carta no inicio da pilha.
   * @param SorteRevesAbs - Carta a ser adicionada
   */
  public void insereInicio(int carta) {
    this.cartas.add(0, carta);
  }
  
  /* Método para adicionar a carata Habeas Corpus
   * @param SorteRevesAbs - Carta Habeas Corpus a ser adicionada
   * 
   */
  public void insereCartaHabeas(){
	  this.cartas.add(0, 5);
	  this.cartaHabeasRetirada = false;
  }
  /* Método para retirar uma carta da lista.
   * @return SorteRevesAbs
   */
  public int remove() {
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
	  
	  insereFinal(1);
	  insereFinal(2);
	  insereFinal(3);
	  insereFinal(4);
	  insereFinal(5);
	  insereFinal(6);
	  insereFinal(7);
	  insereFinal(8);
	  insereFinal(9);
	  insereFinal(10);
	  insereFinal(11);
	  insereFinal(12);
	  insereFinal(13);
	  insereFinal(14);
	  insereFinal(15);
	  insereFinal(16);
	  insereFinal(17);
	  insereFinal(18);
	  insereFinal(19);
	  insereFinal(20);
	  insereFinal(21);
	  insereFinal(22);
	  insereFinal(23);
	  insereFinal(24);
	  insereFinal(25);
	  insereFinal(26);
	  insereFinal(27);
	  insereFinal(28);
	  insereFinal(29);
	  insereFinal(30);
	  insereFinal(31);
  }
  
  /** Método responsável por desenfileirar as cartas 
   */
  public void desinfileirar(int temp){
	  
	  if(temp == 5){
		  this.cartaHabeasRetirada = true;
		  temp = 0;
	  }else if(temp != 5){
		  insereInicio(temp);
	  }		  
  }
  
  /** Método para retornar uma lista de cartas
   * 
   * @return List<SorteRevesAbs>
   */
  public List<Integer> getLista(){
	  
	  return this.cartas;
  }

}