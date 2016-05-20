
package br.eng.augusteiner.poo.soda;

import br.eng.augusteiner.poo.Moeda;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class QuantidadeMoeda {

    private int quantidade;
    private Moeda moeda;

    public QuantidadeMoeda(Moeda moeda, int quantidade) {

        this.moeda = moeda;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {

        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {

        this.quantidade = quantidade;
    }

    public Moeda getMoeda() {

        return moeda;
    }

    public void setMoeda(Moeda moeda) {

        this.moeda = moeda;
    }

    public void addQuantidade(int quantidade) {

        this.quantidade += quantidade;
    }
}
