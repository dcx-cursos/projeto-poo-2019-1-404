package br.com.ufpb.POO;

/**Classe para objetos do tipo Listas, onde serão contidos, valores e métodos do mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

import java.util.ArrayList;

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;

public class Listas {
    private ArrayList<Jogador> jogadores;
    private ArrayList<Jogador> jogadoresJogando;
    private ArrayList<Jogador> jogadoresPresos;
    private ArrayList<CasaDoTabuleiro> tabuleiro;

    public Listas() {
    	this.jogadores = new ArrayList<Jogador>();
    	this.jogadoresJogando = new ArrayList<Jogador>();
    	this.tabuleiro = new ArrayList<CasaDoTabuleiro>();
    	this.jogadoresPresos = new ArrayList<Jogador>();
    }
    
    /**Método para adicionar jogadores a lista de Jogadores
     * @param Jogador - Jogador a ser adicionado
     */

    public void addJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    /**Método para adicionar jogadores da lista Jogadores na lista de JogadoresNaCasaDePartida*/
    
	public void addListaDeJogadoresNaCasaDePartida(){
		for (Jogador jogador : this.jogadores) {
			this.jogadoresJogando.add(jogador);
			this.tabuleiro.get(0).adicionarJogadoresNaListaDaCasa(jogador);
		}
	}

    /**Método para adicionar um Jogador a lista de jogadoresJogando
     * @param Jogador - Jogador a ser adicionado
     */
	
    public void addJogadorJogando(Jogador jogador) {
        this.jogadoresJogando.add(jogador);
    }

    /**Método para adicionar um Jogador a lista de jogadoresPresos
    *@param Jogador - Jogador a ser preso
    */
    
    public void addJogadorPreso(Jogador jogador) {
    	this.jogadoresPresos.add(jogador);
    }

    /**Método para retornar o primeiro Jogador da lista de jogadores
     * @return Jogador - primeiro Jogador
     */

    public Jogador getPrimeiroJogador() {
        return this.jogadores.get(0);
    }

    /**Método buscar e retornar um Jogador pelo seu Id
     * @param int - Id
     * @return Jogador - Jogador encontrado
     */

    public Jogador getJogadorId(int id) {
	    Jogador jogador = null;
	    for (int i = 0; i < this.tabuleiro.size(); i++) {
		    for (Jogador jog : this.tabuleiro.get(i).getJogadoresNaCasa()) {
			    if (jog.getId() == id) {
				    jogador = jog;
			    }
		    }
	    }	 
	return jogador;
    }

    /**Método para retornar a lista de jogadores
     * @return ArrayList<Jogador> - lista de jogadores
     */

    public ArrayList<Jogador> getJogadores() {
        return this.jogadores;
    }

    /**Método para retornar a lista de jogadores jogando
     * @return ArrayList<Jogador> - lista de jogadores jogando
     */

    public ArrayList<Jogador> getJogadoresJogando() {
        return this.jogadoresJogando;
    }

    /**Método setar os jogadores que estão jogando
     * @param Jogador - Jogador
     */

    public void setJogadoresJogando(Jogador jogador) {
        this.jogadoresJogando.remove(jogador);
    }

    /**Método para retornar uma casa pelo Id
     * @param int - Id da casa a ser retornada
     * @return CasaDoTabuleiro - casa encontrada
     */
    
	public CasaDoTabuleiro getCasaById(int id) {
		return tabuleiro.get(id);
	}

    /**Método para retornar a lista de jogadores presos
     * @return ArrayList<Jogador> - lista de jogadores presos
     */

    public ArrayList<Jogador> getJogadoresPresos() {
        return this.jogadoresPresos;
    }

    /**Método para setar os jogadores que estão presos
     * @param Jogador - Jogador
     */

    public void setJogadoresPresos(Jogador jogador) {
        for(Jogador j: this.jogadoresPresos) {
            if(j.equals(jogador)) {
                this.jogadoresPresos.remove(j);
            }
        }
    }
    
    /**Método para retornar o Tabuleiro
     * @return ArrayList<CasaDoTabuleiro> - tabuleiro
     */

    public ArrayList<CasaDoTabuleiro> getTabuleiro() {
    	return this.tabuleiro;
    }

    /**Método para setar o Tabuleiro
     * @param ArrayList<CasaDoTabuleiro> - tabuleiro
     */
    
	public void setTabuleiro(ArrayList<CasaDoTabuleiro> tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}

