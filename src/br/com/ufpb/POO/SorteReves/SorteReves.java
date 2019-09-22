package br.com.ufpb.POO.SorteReves;

import java.io.IOException;

import br.com.ufpb.POO.ControlesTabuleiro;
import br.com.ufpb.POO.Dados;
import br.com.ufpb.POO.Jogador;
import br.com.ufpb.POO.Listas;

/**Classe abstrata para objetos do tipo SorteRevesAbs, onde serão contido, valores e métodos do mesmo.
 * @author Anderson, Ismar, Jobson, Josué
 */

public class SorteReves {
	
    public static void funcaoCarta(int idCarta, Jogador jogadorDaVez)
    {
    	
        int[] cartasPagar = {1, 3, 9, 10, 13, 16, 18, 22, 23, 25, 26, 28, 29, 30};
        int[] cartasReceber = {4, 8, 11, 14, 15, 17, 19, 20, 21, 27, 31};
        
        if(contains(idCarta, cartasPagar))
        {
            try {
            	jogadorDaVez.pagarTaxa(ManipuladoTextCartas.getValorCarta(idCarta));            		
				System.out.println(ManipuladoTextCartas.getStringCarta(idCarta));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
        }

        else if(contains(idCarta, cartasReceber))
        {
            try {
            	jogadorDaVez.receberTaxa(ManipuladoTextCartas.getValorCarta(idCarta));
				System.out.println(ManipuladoTextCartas.getStringCarta(idCarta));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
        }

        else if(idCarta == 2)
        {
            try {
            	for(Jogador jogador: Listas.getInstance().getJogadores())
            	{
            		jogador.receberTaxa(ManipuladoTextCartas.getValorCarta(idCarta));            		
            	}
            	System.out.println(ManipuladoTextCartas.getStringCarta(idCarta));
            } catch(IOException e) {
            	System.out.println(e.getMessage());
            }
        }

        else if(idCarta == 5)
        {
            try {
            	jogadorDaVez.setTemHabeas(true);
				System.out.println(ManipuladoTextCartas.getStringCarta(idCarta));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
        }

        else if(idCarta == 6)
        {
        	try {
				System.out.println(ManipuladoTextCartas.getStringCarta(idCarta));
				ControlesTabuleiro.moverJogador(jogadorDaVez, Listas.getInstance().getTabuleiro().get(30));
				Listas.getInstance().getTabuleiro().get(30).funcaoTabuleiro(jogadorDaVez);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
        }
        
        else if(idCarta == 7)
        {
        	try {
				System.out.println(ManipuladoTextCartas.getStringCarta(idCarta));
				ControlesTabuleiro.moverJogador(jogadorDaVez, Listas.getInstance().getTabuleiro().get(0));
				Listas.getInstance().getTabuleiro().get(0).funcaoTabuleiro(jogadorDaVez);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
        }

        else if(idCarta == 12)
        {
            try {
            	System.out.println(ManipuladoTextCartas.getStringCarta(idCarta));
            	ControlesTabuleiro.jogarDados();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
        }

        else if(idCarta == 24)
        {
            if((Dados.getDado1() + Dados.getDado2()) % 2 == 0)
            {
            	try {
            		System.out.println("------------------------------SORTE------------------------------");
					jogadorDaVez.receberTaxa(ManipuladoTextCartas.getValorCarta(idCarta));
					System.out.println(ManipuladoTextCartas.getStringCarta(idCarta));
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
            }
            else {
            	try {
            		System.out.println("------------------------------REVÉS------------------------------");
            		jogadorDaVez.pagarTaxa(ManipuladoTextCartas.getValorCarta(idCarta));
            		System.out.println(ManipuladoTextCartas.getStringCarta(idCarta));
            	} catch (IOException e) {
            		System.out.println(e.getMessage());
            	}            	
            }
        }
    }

    public static boolean contains(int elemento, int[] cartas)
    {
        for(int num : cartas)
        {
            if(num == elemento)
            {
                return true;
            }
        }
        return false;
    }
	
}