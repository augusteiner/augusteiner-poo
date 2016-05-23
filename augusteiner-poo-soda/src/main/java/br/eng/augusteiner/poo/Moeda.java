
package br.eng.augusteiner.poo;

import static br.eng.augusteiner.poo.soda.Util.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Moeda {

    private static class Nested {

        private static final Iterable<Moeda> MOEDAS_CONHECIDAS;

        static {

            Collection<Moeda> moedas = new ArrayList<Moeda>();

            moedas.add(new Moeda(1.00, "Um Real"));
            moedas.add(new Moeda(0.50, "Cinquenta Centavos"));
            moedas.add(new Moeda(0.25, "Vinte e Cinco Centavos"));
            moedas.add(new Moeda(0.10, "Dez Centavos"));
            moedas.add(new Moeda(0.05, "Cinco Centavos"));

            MOEDAS_CONHECIDAS = Collections.unmodifiableCollection(moedas);
        }
    }

    public static final String SIMBOLO = "R$";

    public static Moeda doValor(double valor) {

        for (Moeda moeda : getMoedasConhecidas()) {

            if (moeda.getValor() == valor) {

                return moeda;
            }
        }

        return null;
    }

    public static Iterable<Moeda> getMoedasConhecidas() {

        return Nested.MOEDAS_CONHECIDAS;
    }

    public static void initMap(Map<Moeda, QuantidadeMoeda> moedas) {

        for (Moeda moeda : getMoedasConhecidas()) {

            moedas.put(
                moeda,
                new QuantidadeMoeda(moeda, 0));
        }
    }

    private double valor;

    private String descricao;

    Moeda(
        double valor,
        String descricao) {

        this.valor = valor;
        this.descricao = descricao;
    }

    public String getDescricao() {

        return descricao;
    }

    public double getValor() {

        return valor;
    }

    void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    void setValor(double valor) {

        this.valor = valor;
    }

    @Override
    public String toString() {

        return String.format(
            LOCALE_PADRAO,
            "%s %.2f (%s)",
            SIMBOLO,
            getValor(),
            getDescricao());
    }
}
