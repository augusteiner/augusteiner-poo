
package br.eng.augusteiner.poo;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Troco {

    private Map<Moeda, QuantidadeMoeda> moedas;

    Troco() {

        moedas = new Hashtable<Moeda, QuantidadeMoeda>();
    }

    public void addMoeda(
        Moeda moeda,
        int quantidade) {

        QuantidadeMoeda qte = this.moedas.get(moeda);

        if (qte == null) {

            qte = new QuantidadeMoeda(moeda, 0);

            this.moedas.put(moeda, qte);
        }

        qte.addQuantidade(quantidade);
    }

    public Iterable<QuantidadeMoeda> getMoedas() {

        return this.moedas.values();
    }

    public double getValor() {

        BigDecimal valor = BigDecimal.ZERO;

        for (QuantidadeMoeda qte : this.getMoedas()) {

            valor = valor.add(BigDecimal.valueOf(qte.getValor()));
        }

        return valor.doubleValue();
    }

    public int quantidadeMoedas(Moeda moeda) {

        QuantidadeMoeda qte = this.moedas.get(moeda);

        return qte != null ? qte.getQuantidade() : 0;
    }

    public void removeMoeda(
        Moeda moeda,
        int quantidade) {

        this.addMoeda(
            moeda,
            -quantidade);
    }
}
