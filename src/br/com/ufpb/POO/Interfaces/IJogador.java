package br.com.ufpb.POO.Interfaces;

/**Classe para interfaces do tipo IJogador, onde contém os métod que devem ser implementados
*/

import br.com.ufpb.POO.Propriedades.PropriedadeComercializavel;

public interface IJogador {

    /**Métodos a serem implementados a quem utilizar esta interface
    */
	public void comprar(PropriedadeComercializavel propriedade);
	public void pagarTaxa(int taxa);
	public void receberTaxa(int taxa);
	public void addPropriedade(PropriedadeComercializavel propriedade);
	public int getQuantPropriedades();
}
