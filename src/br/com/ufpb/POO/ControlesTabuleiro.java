package br.com.ufpb.POO;

import java.util.ArrayList;

/**Classe para objetos do tipo ControlesTabuleiro, onde serão contido, valores e métodos do mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

import java.util.Scanner;

import br.com.ufpb.POO.Propriedades.CasaDoTabuleiro;
import br.com.ufpb.POO.Verificadores.VerificadoresDojogo;

public class ControlesTabuleiro {
	
	private ArrayList<String> comandosDisponiveis;
	private static Jogador jogadorDaVez;
	private InsereJogadores insereJogadores;
	private Scanner scan;
	public static Dados dados;
	private VerificadoresDojogo verificador = new VerificadoresDojogo();
	private static int qtdJogadasSeguidas =  0;
	private static boolean dadosIguais = false;
			
	public ControlesTabuleiro() {
		this.comandosDisponiveis = new ArrayList<String>();
    	Tabuleiro.getInstance();
		this.insereJogadores = new InsereJogadores();
		this.scan = new Scanner(System.in);
		ControlesTabuleiro.dados = new Dados();
		this.inicializaComandos();
	}
	
	public Jogador getJogadorDaVez() {
		return jogadorDaVez;
	}
	
	public void setJogadorDaVez() {
		jogadorDaVez = Listas.getInstance().getJogador();
	}
	
	/**Método para inserir jogadores, onde realiza a chamada do método inciaJogadorDaVez*/
	
	public void inserirJogadores(String nome, String corPeao) {
		this.insereJogadores.inserirJogador(nome, corPeao);
	}

	/**Método para iniciar o Jogador da vez, onde realiza a chamada do método options*/
	
	public void iniciaJogadorDaVez() {
		ControlesTabuleiro.jogadorDaVez = Listas.getInstance().getJogador();
	}

	/**Método para mover o Jogador pelo tabuleiro
	 * @param Jogador - Jogador da vez
	 * @param CasaDoTabuleiro - destino do Jogador*/
	
	public static void moverJogador(Jogador jogadorDaVez, CasaDoTabuleiro destino) {
		destino.mover(jogadorDaVez, destino);
	}
	
	/**Método para obter o Id da próxima casa, a qual o jogador irá chegar
	 * @param int - Id atual do Jogador
	 * @param int - resultado da soma dos valores dos dados
	 * @param Jogador - Jogador da vez
	 * @return int - Id da próxima casa*/

	public static int obterIdProxCasa(int idAtual, int resultado, Jogador jogadorDaVez) {
		int idProxCasa, temp = 0;
		idProxCasa = idAtual + resultado;
		if(idProxCasa > 39) {
			Listas.getInstance().getTabuleiro().get(0).funcaoTabuleiro(jogadorDaVez);
			temp = idProxCasa % 40;
			idProxCasa = temp;
		}
		return idProxCasa;
	}

	/**Método para realizar o "lançamento" dos dados*/
	
	public static void jogarDados() {
		dados.lancarDados();
		CasaDoTabuleiro casaJogador = jogadorDaVez.getPos();

		//Verificar se o jogador jogou mais tr�s vezes seguidas e prend�-lo.

		if (Dados.getDado1()==Dados.getDado2()) {
			qtdJogadasSeguidas+=1;
			System.out.println("\nDados iguais\n"+qtdJogadasSeguidas);
			moverJogador(jogadorDaVez, casaJogador);
			dadosIguais = true;
		}
		
		int indiceCasaDestino = obterIdProxCasa(jogadorDaVez.getIdAtualDoJogador(), dados.resultado(), jogadorDaVez);
		System.out.println("O jogador "+jogadorDaVez.getNome()+" ("+jogadorDaVez.getCorPeao()+") tirou "+Dados.getDado1()+","+Dados.getDado2()+
		" o peão avançou para "+indiceCasaDestino+" - "+Listas.getInstance().getTabuleiro().get(indiceCasaDestino).getNome());
		moverJogador(jogadorDaVez, Listas.getInstance().getCasaById(indiceCasaDestino));
		Listas.getInstance().getCasaById(indiceCasaDestino).funcaoTabuleiro(jogadorDaVez);
		
		dadosIguais = false;
	}
	
	public void jogardadosCarta() {
		jogarDados();
	}

	/**Método para verificar se o Jogador realmente deseja sair*/
	
	public boolean optionSair(){
		System.out.print("Deseja realmente sair?[s/n] ");
		String escolha2 = this.scan.nextLine().toUpperCase();
		if(escolha2.equals("S")) {
			Listas.getInstance().setJogadorSaiu(ControlesTabuleiro.jogadorDaVez);
			return true;
		} else if(!escolha2.equals("N")) {
			System.out.println("Comando indisponível!");
			optionSair();
		}
		return false;
	}

	public void inicializaComandos() {
		this.comandosDisponiveis.add(0, "[sair]");
		this.comandosDisponiveis.add(0, "[status]");
		this.comandosDisponiveis.add(0, "[jogar]");
	}
	
	public void adicionaComandoVender() {
		if(!this.comandosDisponiveis.contains("[vender]"))
		{
			this.comandosDisponiveis.add(0,"[vender]");
		}
	}
	
	public void adicionaComandoConstruir() {
		if(!this.comandosDisponiveis.contains("[construir]"))
		{
			this.comandosDisponiveis.add(0,"[construir]");			
		}
	}
	
	public void rmComandoConstruir() {
		if(this.comandosDisponiveis.contains("[construir]"))
		{
			this.comandosDisponiveis.remove("[construir]");			
		}
	}
	
	public void rmComandoVender() {
		if(this.comandosDisponiveis.contains("[vender]"))
		{
			this.comandosDisponiveis.remove("[vender]");
		}
	}
	
	public String getComandos() {
		String comandos = "";
		for(String s: this.comandosDisponiveis) {
			comandos += ""+s;
		}
		return comandos;
	}
	
	public void Construir() {
		jogadorDaVez.setIdPropriedadesParaConstruir();
		while(this.verificador.verificadorPossuiSaldoParaConstruir(jogadorDaVez))
		{
		System.out.println(""+jogadorDaVez.getNome()+" possui $"+jogadorDaVez.getSaldo());
		System.out.println(jogadorDaVez.toPropriedadesParaConstruir());
			System.out.print("Digite o número da propriedade (0 para sair): ");
			int escolhaConstruir = Integer.parseInt(this.scan.nextLine());
			if(escolhaConstruir >= 1)
			{
				if(this.verificador.verificadorJaTemHotel(jogadorDaVez, escolhaConstruir)) {
					System.out.println("Não pode construir, já existe um hotel construído.");
				}
				else {
					jogadorDaVez.pagarTaxa(jogadorDaVez.getPropriedadesConstruir().get(escolhaConstruir - 1).getValorCasa());
					jogadorDaVez.getPropriedadesConstruir().get(escolhaConstruir - 1).setContCasas(1);					
				}
			}
			if(escolhaConstruir == 0) {
				break;
			}
		}
	}
	
	public void Vender() {
		jogadorDaVez.setIdPropriedadesParaConstruir();
		while(this.verificador.verificadorPossuiSaldoParaConstruir(jogadorDaVez))
		{
		System.out.println(""+jogadorDaVez.getNome()+" possui $"+jogadorDaVez.getSaldo());
		System.out.println(jogadorDaVez.toPropriedadesParaConstruir());
			System.out.print("Digite o número da propriedade (0 para sair): ");
			int escolhaVender = Integer.parseInt(this.scan.nextLine());
			if(escolhaVender >= 1)
			{
				if(this.verificador.verificadorTemCasaParaVender(jogadorDaVez, escolhaVender)) {
					jogadorDaVez.receberTaxa(jogadorDaVez.getPropriedadesConstruir().get(escolhaVender - 1).getValorCasa());
					jogadorDaVez.getPropriedadesConstruir().get(escolhaVender - 1).setContCasas(-1);					
				}
				else {
					break;
				}
			}
			if(escolhaVender == 0) {
				break;
			}
		}
	}
	
	public void Jogar() {
		if(ControlesTabuleiro.dadosIguais)
		{
			jogarDados();
		}
		if(ControlesTabuleiro.dadosIguais && ControlesTabuleiro.qtdJogadasSeguidas>=3) {
			ControlesTabuleiro.jogadorDaVez.setEstaPreso(true);
			ControlesTabuleiro.qtdJogadasSeguidas = 0;
			Listas.getInstance().getCasaById(30).funcaoTabuleiro(ControlesTabuleiro.jogadorDaVez);
		}
		ControlesTabuleiro.qtdJogadasSeguidas = 0;
		jogarDados();
	}
	
	public String getVencedor()
	{
		return "\nJogador "+Listas.getInstance().getJogadoresJogando().get(0).getNome()+" - "+Listas.getInstance().getJogadoresJogando().get(0).getCorPeao()+", é o Vencedor!";
	}

}
