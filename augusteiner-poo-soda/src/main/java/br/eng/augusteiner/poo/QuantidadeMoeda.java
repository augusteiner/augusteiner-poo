
package br.eng.augusteiner.poo;

import static br.eng.augusteiner.poo.soda.Util.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
class QuantidadeMoeda implements IQuantidadeMoeda {

    public static void incrementarNoMap(
        Map<Moeda, QuantidadeMoeda> map,
        Moeda moeda,
        int quantidade) {

        QuantidadeMoeda qte = map.get(moeda);

        if (qte == null) {

            qte = new QuantidadeMoeda(moeda, 0);
            map.put(moeda, qte);
        }

        qte.addQuantidade(quantidade);
    }

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

    @Override
    public Moeda getMoeda() {

        return moeda;
    }

    @Override
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
