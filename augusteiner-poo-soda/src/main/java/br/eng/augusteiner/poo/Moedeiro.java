
package br.eng.augusteiner.poo;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
class Moedeiro implements IMoedeiro {

    private Map<Moeda, QuantidadeMoeda> moedas;

    protected Moedeiro() {

        moedas = new Hashtable<Moeda, QuantidadeMoeda>();
    }

    @Override
    public void addMoeda(Moeda moeda) {

        this.addMoeda(
            moeda,
            1);
    }

    @Override
    public void addMoeda(
        Moeda moeda,
        int quantidade) {

        QuantidadeMoeda.incrementarNoMap(
            this.moedas,
            moeda,
            quantidade);
    }

    @Override
    public Iterable<? extends IQuantidadeMoeda> getMoedas() {

        return this.moedas.values();
    }

    @Override
    public int quantidadeMoedas(Moeda moeda) {

        QuantidadeMoeda qte = this.moedas.get(moeda);

        return qte != null ? qte.getQuantidade() : 0;
    }

    @Override
    public void removeMoeda(Moeda moeda) {

        this.removeMoeda(
            moeda,
            1);
    }

    @Override
    public void removeMoeda(
        Moeda moeda,
        int quantidade) {

        //System.out.println(String.format(
        //    "Removendo moeda %s (%d)",
        //    moeda,
        //    quantidade));

        addMoeda(
            moeda,
            - quantidade);
    }
}
