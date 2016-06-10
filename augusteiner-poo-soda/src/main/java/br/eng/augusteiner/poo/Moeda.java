
package br.eng.augusteiner.poo;

import static br.eng.augusteiner.poo.soda.Util.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Moeda {

    private static class Nested {

        private static final Iterable<Moeda> MOEDAS_SUPORTADAS;

        static {

            Collection<Moeda> moedas = new ArrayList<Moeda>();

            moedas.add(new Moeda(1.00, "Um Real"));
            moedas.add(new Moeda(0.50, "Cinquenta Centavos"));
            moedas.add(new Moeda(0.25, "Vinte e Cinco Centavos"));
            moedas.add(new Moeda(0.10, "Dez Centavos"));
            moedas.add(new Moeda(0.05, "Cinco Centavos"));

            MOEDAS_SUPORTADAS = Collections.unmodifiableCollection(moedas);
        }

        public static Iterable<Moeda> getMoedasSuportadas() {

            return MOEDAS_SUPORTADAS;
        }
    }

    public static final String SIMBOLO = "R$";

    public static Moeda doValor(double valor) {

        for (Moeda moeda : getMoedasSuportadas()) {

            if (moeda.getValor() == valor) {

                return moeda;
            }
        }

        return null;
    }

    public static Iterable<Moeda> getMoedasSuportadas() {

        return Nested.getMoedasSuportadas();
    }

    public static void initMap(Map<Moeda, QuantidadeMoeda> moedas) {

        initMap(moedas, getMoedasSuportadas());
    }

    public static void initMap(
        Map<Moeda, QuantidadeMoeda> moedas,
        Iterable<Moeda> moedasPermitidas) {

        for (Moeda moeda : moedasPermitidas) {

            moedas.put(
                moeda,
                new QuantidadeMoeda(moeda, 0));
        }
    }

    public static Iterable<Moeda> moedasMenoresQue(Moeda moedaMaior) {

        List<Moeda> moedas = new ArrayList<Moeda>();

        for (Moeda moeda : getMoedasSuportadas()) {

            if (moeda.getValor() < moedaMaior.getValor()) {

                moedas.add(moeda);
            }
        }

        return moedas;
    }

    private double valor;

    private String descricao;

    private Moeda(
        double valor,
        String descricao) {

        this.valor = valor;
        this.descricao = descricao;
    }

    public String getDescricao() {

        return this.descricao;
    }

    public double getValor() {

        return this.valor;
    }

    @Override
    public String toString() {

        return String.format(
            LOCALE_PADRAO,
            "%s %.2f (%s)",
            SIMBOLO,
            this.getValor(),
            this.getDescricao());
    }
}
