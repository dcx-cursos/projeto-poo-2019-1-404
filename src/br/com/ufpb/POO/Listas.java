package br.com.ufpb.POO;

/**Classe para objetos do tipo Listas, onde serão contidos, valores e métodos do mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

import java.util.ArrayList;

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.SorteReves.PilhaCartas;

public class Listas {
	private static Listas instance;
    private ArrayList<Jogador> jogadores;
    private ArrayList<Jogador> jogadoresJogando;
    private ArrayList<Jogador> jogadoresPresos;
    private ArrayList<CasaDoTabuleiro> tabuleiro;
    private PilhaCartas deck;

    private Listas() {
    	this.jogadores = new ArrayList<Jogador>();
    	this.jogadoresJogando = new ArrayList<Jogador>();
    	this.tabuleiro = new ArrayList<CasaDoTabuleiro>();
    	this.jogadoresPresos = new ArrayList<Jogador>();
    	this.deck = new PilhaCartas();
    }
    
    public static Listas getInstance()
    {
    	if(instance == null)
    	{
    		synchronized (Listas.class) {
    			if(instance == null) 
    			{
    				instance = new Listas();    				
    			}
			}
    	}
    	
    	return instance;
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
			this.jogadoresJogando.add(0, jogador);
			this.tabuleiro.get(0).adicionarJogadoresNaListaDaCasa(jogador);
		}
	}

    /**Método para adicionar um Jogador a lista de jogadoresJogando
     * @param Jogador - Jogador a ser adicionado
     */
	
    public void addJogadorJogando(Jogador jogador) {
        this.jogadoresJogando.add(0, jogador);
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

    public Jogador getJogador() {
    	Jogador temp = this.jogadoresJogando.get(this.jogadoresJogando.size() - 1);
    	setJogadoresJogando();
    	addJogadorJogando(temp);
        return temp;
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

    public Jogador setJogadoresJogando() {
        return this.jogadoresJogando.remove(this.jogadoresJogando.size() - 1);
    }
    
    public void setJogadorSaiu(Jogador jogador)
    {
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
	/** Método para obter o deck de cartas
	 * @return PilhaCartas
	 */
	public PilhaCartas getDeck()
	{
		return this.deck;
	}
}
