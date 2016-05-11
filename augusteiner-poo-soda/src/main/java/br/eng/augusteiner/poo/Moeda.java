
package br.eng.augusteiner.poo;

import java.util.Locale;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Moeda {

    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
    public static final Locale LOCALE_PADRAO = LOCALE_PT_BR;
    public static final String SIMBOLO = "R$";

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

    public double getValor() {

        return valor;
    }

    public void setValor(double valor) {

        this.valor = valor;
    }

    public String getDescricao() {

        return descricao;
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
}
