
package br.eng.augusteiner.poo;

import static br.eng.augusteiner.poo.Moeda.*;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
class Moedeiro implements IMoedeiro {

    public static final void initMoedeiro(
        Moedeiro moedeiro,
        Iterable<Moeda> moedasPermitidas) {

        initMap(
            moedeiro.moedas,
            moedasPermitidas);
    }

    public static final Moedeiro moedeiroComMoedasDe(Iterable<Moeda> moedasPermitidas) {

        Moedeiro moedeiro = new Moedeiro();

        initMoedeiro(
            moedeiro,
            moedasPermitidas);

        return moedeiro;
    }

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

        QuantidadeMoeda qte = this.moedas.get(moeda);

        qte.addQuantidade(quantidade);
    }

    @Override
    public Iterable<? extends IQuantidadeMoeda> getMoedas() {

        return this.moedas.values();
    }

    @Override
    public int getQuantidadeMoedas(Moeda moeda) {

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
