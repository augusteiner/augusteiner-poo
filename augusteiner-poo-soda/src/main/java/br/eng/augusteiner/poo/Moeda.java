
package br.eng.augusteiner.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Moeda {

    private static class Nested {

        private static final List<Moeda> MOEDAS_CONHECIDAS;

        static {

            List<Moeda> list = new ArrayList<Moeda>();

            list.add(new Moeda(0.05, "cinco centavos"));
            list.add(new Moeda(0.1, "dez centavos"));
            list.add(new Moeda(0.25, "vinte e cinco centavos"));
            list.add(new Moeda(0.50, "cinquenta centavos"));
            list.add(new Moeda(1.00, "um real"));

            MOEDAS_CONHECIDAS = list;
        }
    }
    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
    public static final Locale LOCALE_PADRAO = LOCALE_PT_BR;

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

    private double valor;

    private String descricao;

    public Moeda() {

    }

    public Moeda(
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

    public void setDescricao(String descricao) {

        this.descricao = descricao;
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

    public static void initMap(Map<Moeda, QuantidadeMoeda> moedas) {

        for (Moeda moeda : getMoedasConhecidas()) {

            moedas.put(
                moeda,
                new QuantidadeMoeda(moeda, 0));
        }
    }
}
