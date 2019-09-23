package br.com.ufpb.POO;

import java.util.Scanner;

import br.com.ufpb.POO.Verificadores.VerificadoresDojogo;

public class FachadaControles {

	private boolean executando;
	
	private Scanner scan;
	private VerificadoresDojogo verificador;
	private InsereJogadores inserirJogadores;
	private ControlesTabuleiro controles;
	
	public FachadaControles() {
		this.executando = true;
		this.scan = new Scanner(System.in);
		this.verificador = new VerificadoresDojogo();
		this.inserirJogadores = new InsereJogadores();
		this.controles = new ControlesTabuleiro();
	}
	
	public void criarJogador(String nome, String corPeao) {
		this.controles.inserirJogadores(nome, corPeao);			
		this.inserirJogadores.getCores().remove(corPeao);
	}

	public void perguntaJogadores()
	{
		System.out.print("Digite o número de jogadores [2-8]: ");
		String n = this.scan.nextLine();
		if(this.verificador.ValorisValido(n)) {
			for(int k = 0; k < Integer.parseInt(n); k++) {
				String nome = getNome(k);
				String corPeao = getCor(k);
				criarJogador(nome, corPeao);
				}
			this.inserirJogadores.inserirJogadoresNaCasaDePartida();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("O Banco Imobiliário vai começar. Aproveite!");
			this.controles.iniciaJogadorDaVez();
			opcoesJogo();
		}else {
				perguntaJogadores();
			}
	}
	
	public String getNome(int number) {
		System.out.print("Digite o nome do Jogador "+(number+1)+": ");
		String nome = this.scan.nextLine();
		if(!verificador.nomeIsValido(nome, Listas.getInstance().getJogadores())){
			return getNome(number);
		}
		return nome;
	}
	
	public String getCor(int number) {
		System.out.print("Escolha a cor do peão do jogador "+(number+1)+" entre as opções seguintes:\n"+inserirJogadores.criaPrintCores()+"\n: ");
		String corPeao = this.scan.nextLine();
		if(!verificador.corExiste(corPeao, this.inserirJogadores.getCores())){
			return getCor(number);
		}
		return corPeao;
	}
	
	public void opcoesJogo()
	{
		if(this.verificador.verificarQuantJogadores()) {
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.print("A jogada de "+this.controles.getJogadorDaVez().getNome()+" ("+this.controles.getJogadorDaVez().getCorPeao()+") começou.\n");
			if(this.verificador.verificadorPodeConstruir(this.controles.getJogadorDaVez()) && this.verificador.verificadorPossuiSaldoParaConstruir(this.controles.getJogadorDaVez())) {
				this.controles.adicionaComandoVender();
				this.controles.adicionaComandoConstruir();
			}
			else if(this.verificador.verificadorPodeConstruir(this.controles.getJogadorDaVez()) && !this.verificador.verificadorPossuiSaldoParaConstruir(this.controles.getJogadorDaVez())) {
				this.controles.rmComandoConstruir();
				this.controles.adicionaComandoVender();
			}
			else {
				this.controles.rmComandoVender();
				this.controles.rmComandoConstruir();
			}
			System.out.println("Comandos disponíveis: "+this.controles.getComandos());
			System.out.print("Digite um comando: ");
			String comando = this.scan.nextLine().toUpperCase();
			if(this.verificador.verificarComandoDigitado(comando) == 1) Jogar();
			if(this.verificador.verificarComandoDigitado(comando) == 2) Status();
			if(this.verificador.verificarComandoDigitado(comando) == 3) Sair();
			if(this.verificador.verificadorPodeConstruir(this.controles.getJogadorDaVez()))
			{
				if(this.verificador.verificarComandoDigitado(comando) == 4) ConstruirCasa();
				if(this.verificador.verificarComandoDigitado(comando) == 5) VenderCasa(); 
			}
			this.controles.setJogadorDaVez();
			opcoesJogo();
		}
		else {
			this.executando = false;
		}
	}
	
	/**Método que inicia o Jogo, onde realiza a chamada do método do inserirJogadores*/
	
	public void iniciarJogo() {
		if(this.executando) {
			perguntaJogadores();
		}
		System.out.println(this.controles.getVencedor());
	}
	
	public void ConstruirCasa() {
		this.controles.Construir();
		opcoesJogo();
	}
	
	public void VenderCasa() {
		this.controles.Vender();
		opcoesJogo();
	}
	
	public void Jogar() {
		this.controles.Jogar();
	}
	
	public void Status() {
		System.out.println("--------------STATUS--------------");
		System.out.println(this.controles.getJogadorDaVez().toStatus());
		opcoesJogo();
	}
	
	public void Sair() {
		if(!this.controles.optionSair()) {
			opcoesJogo();
		}
	}
}
