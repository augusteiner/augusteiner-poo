
package br.eng.augusteiner.poo;

import static br.eng.augusteiner.poo.soda.Util.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class QuantidadeMoeda {

    private int quantidade;
    private Moeda moeda;

    public QuantidadeMoeda(
        Moeda moeda,
        int quantidade) {

        this.moeda = moeda;
        this.quantidade = quantidade;
    }

    public void addQuantidade(int quantidade) {

        this.quantidade += quantidade;
    }

    public Moeda getMoeda() {

        return moeda;
    }

    public int getQuantidade() {

        return this.quantidade;
    }

    public double getValor() {

        return moedasToDouble(this);
    }

    @Override
    public String toString() {

        return String.format(
            LOCALE_PADRAO,
            "R$ %.2f (%s)",
            this.getMoeda().getValor(),
            this.getQuantidade());
    }
}
