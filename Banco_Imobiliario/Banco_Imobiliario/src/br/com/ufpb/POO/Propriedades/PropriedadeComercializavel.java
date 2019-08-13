package br.com.ufpb.POO.Propriedades;
/** Classe para objetos do tipo PropriedadeComercializavel, onde serão contidos, valores e métodos para os mesmos.
 */
import br.com.ufpb.POO.Jogador;

public class PropriedadeComercializavel extends CasaDoTabuleiro{
    private String nome;
    private int valor;
    private Jogador proprietario;
    private int taxa;
    private int taxa1;
    private int taxa2;
    private int taxa3;
    private int taxa4;
    private int valorHotel;
    private int valorCasa;
    private boolean vendido;
    private int mult;
    private int id;
    private String cor_regiao;

    public PropriedadeComercializavel(String nome, String cor_regiao, int valor, int taxa,int taxa1,int taxa2,int taxa3,int taxa4,int valorHotel, int valorCasa, int mult,  int id){
        this.nome = nome;
        this.cor_regiao = cor_regiao;
        this.valor = valor;
        this.proprietario = null;
        this.taxa = taxa;
        this.taxa1 = taxa1;
        this.taxa2 = taxa2;
        this.taxa3 = taxa3;
        this.taxa4 = taxa4;
        this.valorHotel = valorHotel;
        this.valorCasa = valorCasa;
        this.mult = mult;
        this.vendido = false;
        super.setIndice(id);
    }

    /** Método para retornar o nome da propriedade
     *  @return String - Nome da propriedade
     */
    public String getNome() {
        return this.nome;
    }
    
    /** Método para retornar a cor da região
     *  @return String - Cor da Região
     */
    public String getCorRegiao() {
    	return this.cor_regiao;
    }

    /** Método para retornar o valor da propriedade
     *  @return int - Valor da propriedade
     */
	public int getValor() {
		return this.valor;
    }
    
    /** Método para retornar o dono da propriedade
     *  @return Jogador - Proprietário
     */
    public Jogador getProprietario() {
        return this.proprietario;
    }
    
    /** Método para setar o dono/proprietário
     *  @param proprietario Jogador - Dono
     */
    public void setProprietario(Jogador proprietario) {
    	this.proprietario = proprietario;
    }

    /** Método para retornar a taxa do aluguel normal
     *  @return int - Taxa normal do aluguel
     */
	public int getTaxa() {
		return this.taxa;
    }
    
    /** Método para retornar a taxa do aluguel com 1 casa
     *  @return int - Taxa do aluguel de 1 casa
     */
	public int getTaxa1() {
		return this.taxa1;
	}
    
    /** Método para retornar a taxa do aluguel com 2 casas
     *  @return int - Taxa do aluguel de 2 casas
     */
	public int getTaxa2() {
		return this.taxa2;
	}
    
    /** Método para retornar a taxa do aluguel com 3 casas
     *  @return int - Taxa do aluguel de 3 casas
     */
	public int getTaxa3() {
		return this.taxa3;
	}
    
    /** Método para retornar a taxa do aluguel com 4 casas
     *   @return int - Taxa do aluguel de 4 casas
     */
	public int getTaxa4() {
		return this.taxa4;
	}
    
    /** Método para retornar o valor do hotel
     *  @return int - Valor do hotel
     */
	public int getValorHotel() {
		return this.valorHotel;
	}
    
    /** Método para retornar o valor da casa
     *  @return int - Valor da casa
     */
	public int getValorCasa() {
		return this.valorCasa;
	}
    
    /** Método para retornar o multiplicador
     *  @return int - Multiplicador da soma dos dados
     */
	public int getMult() {
		return this.mult;
	}
    
    /** Método para verificar se a propriedade está vendida
     *   @return boolean - Está vendido ou não (true ou falses)
     */
    public boolean estaVendido() {
        return this.vendido;
    }
    
    /** Método para setar se propriedade está vendida
     *   @param vendido boolean - Valor lógico se a propriedade está vendida
     */
    public void setVendido(boolean vendido) {
    	this.vendido = vendido;
    }
    
    /** Método para retornar o ID da propriedade
     *  @return int - Identificador da propriedade
     */
    public int getId() {
    	return this.id;
    }
    
    /** Método para setar o ID da propriedade
     *  @param id int - Identificador da propriedade
     */
    public void setId(int id) {
    	this.id = id;
    }
}
