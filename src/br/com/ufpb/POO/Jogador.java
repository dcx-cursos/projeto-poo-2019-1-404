package br.com.ufpb.POO;

/**Classe para objetos do tipo Jogador, onde serão contidos, valores e métodos para o mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

import java.util.ArrayList;

import br.com.ufpb.POO.Interfaces.IJogador;
import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavel;

public class Jogador implements IJogador{
	private static int ultimoId = 0;
	private String nome;
    private String cor_peao;
    private CasaDoTabuleiro posicao;
    private int saldo;
    private int id;
    private int idAtualJogador;
    private ArrayList<PropriedadeComercializavel> minhasPropriedades;
    private boolean estaPreso;
    private boolean temHabeas;
    private boolean usouHabeas;

    public Jogador(String nome, String cor_peao, CasaDoTabuleiro posicao, int saldo) {
        this.nome = nome;
        this.cor_peao = cor_peao;
        this.posicao = posicao;
        this.saldo = saldo;
        this.id = ultimoId++;
        this.idAtualJogador = 0;
        this.minhasPropriedades = new ArrayList<PropriedadeComercializavel>();
        this.estaPreso = false;
        this.temHabeas = false;
        this.usouHabeas = false;
    }
    
    /**Método para retorno do nome do Jogador
     * @return String - nome do Jogador*/

    public String getNome() {
        return this.nome;
    }

    /**Método para setar o nome do Jogador
     * @param String - novo nome do Jogador*/
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**Método para retorno da cor do peão do Jogador
     * @return String - cor do peão do Jogador*/

    public String getCorPeao() {
        return this.cor_peao;
    }

    /**Método para setar a cor do peão do Jogador
     * @param String - nova cor do Jogador*/

    public void setCorPeao(String cor) {
        this.cor_peao = cor;
    }

    /**Método para retornar a posição, no tabuleiro, do Jogador
     * @return CasaDoTabuleiro - posição do Jogador*/

    public CasaDoTabuleiro getPos() {
        return this.posicao;
    }

    /**Método para setar a posição do Jogador
     * @param CasaDoTabuleiro - nova posição do Jogador
     */

    public void setPos(CasaDoTabuleiro pos) {
        this.posicao = pos;
    }

    /**Método para retorno do saldo do Jogador
     * @return int - saldo do Jogador*/

    public int getSaldo() {
        return this.saldo;
    }

    /**Método para setar o saldo do Jogador
     * @param int - novo saldo*/

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**Método para retorno do Id do Jogador
     * @return int - id do Jogador*/

    public int getId() {
        return this.id;
    }

    /**Método para setar o Id do Jogador
     * @param int - novo Id do jogador*/
    
    public void setId(int id) {
    	this.id = id;
    }

    /**Método para retornar o Id atual, número da casa do tabuleiro, do Jogador
     * @return int - Id atual do Jogador*/
    
    public int getIdAtualDoJogador() {
    	return this.idAtualJogador;
    }

    /**Método para setar o Id atual do Jogador
     * @param int - novo Id atual do Jogador*/
    
    public void setIdAtualDoJogador(int idAtualJogador) {
    	this.idAtualJogador = idAtualJogador;
    }

    /**Método para efetuar a compra de alguma propriedade
     * @param PropriedadeComercializavel - propriedade a ser comprada*/

    public void comprar(PropriedadeComercializavel propriedade) {
		propriedade.setProprietario(this);
		propriedade.setVendido(true);
		addPropriedade(propriedade);
        this.saldo -= propriedade.getValor();
    }

    /**Método para efetuar o pagamento de taxa(aluguel) do Jogador
     * @param int - valor da taxa a ser paga*/

    public void pagarTaxa(int valorTaxa) {
        this.saldo -= valorTaxa;
    }

    /**Método para realizar o recebimento da taxa(aluguel) para o Jogador
     * @param int - valor da taxa a ser recebida*/

    public void receberTaxa(int valorTaxa) {
        this.saldo += valorTaxa;
    }

    /**Método para adicionar Propriedade ao portfólio do Jogador
     * @param PropriedadeComercializavel - Propriedade a ser adicionada*/

    public void addPropriedade(PropriedadeComercializavel propriedade) {
        this.minhasPropriedades.add(propriedade);
    }

    /**Método para remover uma Propriedade do portfólio do Jogador
     * @param PropriedadeComercializavel - Propriedade a ser removida*/

    public void rmPropriedade(PropriedadeComercializavel propriedade) {
        this.minhasPropriedades.remove(propriedade);
    }

    /**Método para retornar a lista de Propriedades do Jogador
     * @return PropriedadeComercializavel - lista de Propriedades do Jogador*/

    public ArrayList<PropriedadeComercializavel> getMinhasPropriedades() {
        return this.minhasPropriedades;
    }

    /**Método para setar a(s) Propriedade(s) do Jogador
     * @param PropriedadeComercializavel - Propriedade
     */

    public void setMinhasPropriedades(PropriedadeComercializavel propriedade) {
        for(PropriedadeComercializavel p : this.minhasPropriedades) {
            if(p.equals(propriedade)) {
                rmPropriedade(propriedade);
            }
        }
    }

    /**Método para retornar a quant de Propriedades o Jogador possui
     * @return int - quant de Propriedades*/
    
    public int getQuantPropriedades() {
    	return this.minhasPropriedades.size();
    }
    
    public boolean getEstaPreso()
    {
    	return this.estaPreso;
    }
    
    public void setEstaPreso(boolean condition)
    {
    	this.estaPreso = condition;
    }
    
    public boolean getTemHabeas()
    {
    	return this.temHabeas;
    }
    
    public void setTemHabeas(boolean condition)
    {
    	this.temHabeas = condition;
    }
    
    public boolean getUsouHabeas()
    {
    	return this.usouHabeas;
    }
    
    public void setUsouHabeas(boolean condition)
    {
    	this.usouHabeas = condition;
    }

    /**Método para retornar uma String contendo o status(informações) do Jogador
     * @return String - String com status do Jogador*/

    public String toStatus() {
    	String titulosImoveis = "";
    	String titulosCompanhias = "";
    	for(PropriedadeComercializavel c: this.getMinhasPropriedades()) {
    		if(c.getClass().getSimpleName().equals("PropriedadeComercializavelImovel")) {
    			titulosImoveis += "["+c.getNome()+"] - propriedade "+c.getCorRegiao()+", aluguel "+c.getTaxa()+"\n";     			
    		}
    		else {
    			titulosCompanhias += "["+c.getNome()+"] - multiplicador de $"+c.getMult()+"\n";     			
    		}
    	}
    	String titulos = ""+titulosImoveis+""+titulosCompanhias;
    	return "O status de "+this.getNome()+" - "+this.getCorPeao()+" é o seguinte:"
    			+ "\nSituado na posição "+this.getIdAtualDoJogador()+" - "+this.getPos().getNome()+""
    					+ "\nPossui $"+this.getSaldo()+""
    							+ "\nTítulos:"
    							+ "\n"+titulos;
    }
}
