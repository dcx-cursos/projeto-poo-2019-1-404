package br.com.ufpb.POO;

/**Classe para objetos do tipo Jogador, onde ser�o contidos, valores e m�todos para o mesmo.
 * @author Anderson, Ismar, Jobson, Josu�
 */

import java.util.ArrayList;

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavel;
import br.com.ufpb.POO.Propriedades.PropriedadeComercializavelImovel;

public class Jogador {
	private static int ultimoId = 0;
	private String nome;
    private String cor_peao;
    private CasaDoTabuleiro posicao;
    private int saldo;
    private int id;
    private int idAtualJogador;
    private ArrayList<PropriedadeComercializavel> minhasPropriedades;
    private ArrayList<PropriedadeComercializavelImovel> propriedadesParaConstruir = new ArrayList<PropriedadeComercializavelImovel>();
    private boolean estaPreso;
    private boolean temHabeas;
    private boolean usouHabeas;
    private int verde = 0;
    private int lilas = 0;
    private int amarelo = 0;
    private int azul = 0;
    private int laranja = 0;
    private int vermelho = 0;
    private int roxo = 0;
    private int celeste = 0;
    
    /* Construtor que recebe um nome, uma cor do peao, uma posi��o no tabuleiro e um salario.
     */
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
    
    /**M�todo para retorno do nome do Jogador
     * @return String - nome do Jogador*/

    public String getNome() {
        return this.nome;
    }

    /**M�todo para setar o nome do Jogador
     * @param String - novo nome do Jogador*/
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**M�todo para retorno da cor do pe�o do Jogador
     * @return String - cor do pe�o do Jogador*/

    public String getCorPeao() {
        return this.cor_peao;
    }

    /**M�todo para setar a cor do pe�o do Jogador
     * @param String - nova cor do Jogador*/

    public void setCorPeao(String cor) {
        this.cor_peao = cor;
    }

    /**M�todo para retornar a posi��o, no tabuleiro, do Jogador
     * @return CasaDoTabuleiro - posi��o do Jogador*/

    public CasaDoTabuleiro getPos() {
        return this.posicao;
    }

    /**M�todo para setar a posi��o do Jogador
     * @param CasaDoTabuleiro - nova posi��o do Jogador
     */

    public void setPos(CasaDoTabuleiro pos) {
        this.posicao = pos;
    }

    /**M�todo para retorno do saldo do Jogador
     * @return int - saldo do Jogador*/

    public int getSaldo() {
        return this.saldo;
    }

    /**M�todo para setar o saldo do Jogador
     * @param int - novo saldo*/

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**M�todo para retorno do Id do Jogador
     * @return int - id do Jogador*/

    public int getId() {
        return this.id;
    }

    /**M�todo para setar o Id do Jogador
     * @param int - novo Id do jogador*/
    
    public void setId(int id) {
    	this.id = id;
    }

    /**M�todo para retornar o Id atual, n�mero da casa do tabuleiro, do Jogador
     * @return int - Id atual do Jogador*/
    
    public int getIdAtualDoJogador() {
    	return this.idAtualJogador;
    }

    /**M�todo para setar o Id atual do Jogador
     * @param int - novo Id atual do Jogador*/
    
    public void setIdAtualDoJogador(int idAtualJogador) {
    	this.idAtualJogador = idAtualJogador;
    }

    /**M�todo para efetuar a compra de alguma propriedade
     * @param PropriedadeComercializavel - propriedade a ser comprada*/

    public void comprar(PropriedadeComercializavel propriedade) {
    	if(propriedade.getCorRegiao() == "verde") this.verde +=1;
    	if(propriedade.getCorRegiao() == "lil�s") this.lilas +=1;
    	if(propriedade.getCorRegiao() == "amarelo") this.amarelo +=1;
    	if(propriedade.getCorRegiao() == "azul") this.azul +=1;
    	if(propriedade.getCorRegiao() == "laranja") this.laranja +=1;
    	if(propriedade.getCorRegiao() == "vermelho") this.vermelho +=1;
    	if(propriedade.getCorRegiao() == "roxo") this.roxo +=1;
    	if(propriedade.getCorRegiao() == "celeste") this.celeste +=1;
		propriedade.setProprietario(this);
		propriedade.setVendido(true);
		addPropriedade(propriedade);
        this.saldo -= propriedade.getValor();
    }

    /**M�todo para efetuar o pagamento de taxa(aluguel) do Jogador
     * @param int - valor da taxa a ser paga*/

    public void pagarTaxa(int valorTaxa) {
        this.saldo -= valorTaxa;
    }

    /**M�todo para realizar o recebimento da taxa(aluguel) para o Jogador
     * @param int - valor da taxa a ser recebida*/

    public void receberTaxa(int valorTaxa) {
        this.saldo += valorTaxa;
    }

    /**M�todo para adicionar Propriedade ao portf�lio do Jogador
     * @param PropriedadeComercializavel - Propriedade a ser adicionada*/

    public void addPropriedade(PropriedadeComercializavel propriedade) {
        this.minhasPropriedades.add(propriedade);
    }

    /**M�todo para remover uma Propriedade do portf�lio do Jogador
     * @param PropriedadeComercializavel - Propriedade a ser removida*/

    public void rmPropriedade(PropriedadeComercializavel propriedade) {
        this.minhasPropriedades.remove(propriedade);
    }

    /**M�todo para retornar a lista de Propriedades do Jogador
     * @return PropriedadeComercializavel - lista de Propriedades do Jogador*/

    public ArrayList<PropriedadeComercializavel> getMinhasPropriedades() {
        return this.minhasPropriedades;
    }

    /**M�todo para setar a(s) Propriedade(s) do Jogador
     * @param PropriedadeComercializavel - Propriedade
     */

    public void setMinhasPropriedades(PropriedadeComercializavel propriedade) {
        for(PropriedadeComercializavel p : this.minhasPropriedades) {
            if(p.equals(propriedade)) {
                rmPropriedade(propriedade);
            }
        }
    }

    /**M�todo para retornar a quant de Propriedades o Jogador possui
     * @return int - quant de Propriedades*/
    public int getQuantPropriedades() {
    	return this.minhasPropriedades.size();
    }
    
    public ArrayList<PropriedadeComercializavelImovel> getPropriedadesConstruir()
    {
    	return this.propriedadesParaConstruir;
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
    
    public boolean PodeContruir()
    {
    	if(this.verde == 4) return true;
    	if(this.lilas == 3) return true;
    	if(this.amarelo == 3) return true;
    	if(this.verde == 4) return true;
    	if(this.azul == 2) return true;
    	if(this.laranja == 2) return true;
    	if(this.vermelho == 2) return true;
    	if(this.roxo == 3) return true;
    	if(this.celeste == 3) return true;
    	return false;
    }
    
    public void setIdPropriedadesParaConstruir()
    {
    	for(int id = 0; id < this.minhasPropriedades.size(); id ++)
    	{
    		if(this.minhasPropriedades.get(id).getClass().getSimpleName().equals("PropriedadeComercializavelImovel")) {
    			if(!this.propriedadesParaConstruir.contains(this.minhasPropriedades.get(id)))
    			{
    				this.propriedadesParaConstruir.add((PropriedadeComercializavelImovel) this.minhasPropriedades.get(id));
    			}
    		}
    	}
    }
    
    public String toPropriedadesParaConstruir()
    {
    	String opcoesParaConstruir = "";
    	for(int i = 0; i < this.propriedadesParaConstruir.size(); i++)
    	{
    		if(this.propriedadesParaConstruir.get(i).getContCasas() == 5) {
        		opcoesParaConstruir += ""+(i+1)+" - "+this.propriedadesParaConstruir.get(i).getNome()+" tem 1 hotel construido, hotel custa "+this.propriedadesParaConstruir.get(i).getValorHotel()+"\n";
    		}
    		else {
    			opcoesParaConstruir += ""+(i+1)+" - "+this.propriedadesParaConstruir.get(i).getNome()+" tem "+this.propriedadesParaConstruir.get(i).getContCasas()+" casa(s) construidas, casa custa "+this.propriedadesParaConstruir.get(i).getValorCasa()+"\n";    			
    		}
    	}
    	return opcoesParaConstruir;
    }

    /**M�todo para retornar uma String contendo o status(informa��es) do Jogador
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
    	return "O status de "+this.getNome()+" - "+this.getCorPeao()+" � o seguinte:"
    			+ "\nSituado na posi��o "+this.getIdAtualDoJogador()+" - "+this.getPos().getNome()+""
    					+ "\nPossui $"+this.getSaldo()+""
    							+ "\nT�tulos:"
    							+ "\n"+titulos;
    }
}