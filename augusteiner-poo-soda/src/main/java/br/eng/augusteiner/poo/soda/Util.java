
package br.eng.augusteiner.poo.soda;

import static br.eng.augusteiner.poo.Moeda.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;

import br.eng.augusteiner.poo.Moeda;
import br.eng.augusteiner.poo.QuantidadeMoeda;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Util {

    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
    public static final Locale LOCALE_PADRAO = LOCALE_PT_BR;

    public static String moedasToString(Moeda... moedas) {

        StringBuffer buffer = new StringBuffer();
        String delim = "";

        for (Moeda m : moedas) {

            buffer.append(String.format(
                LOCALE_PADRAO,
                delim + "%s %.2f",
                SIMBOLO,
                m.getValor()));

            delim = " + ";
        }

        return buffer.append(
            String.format(
                LOCALE_PADRAO,
                " = %s %.2f",
                SIMBOLO,
                moedasToDouble(moedas)))
            .toString();
    }

    public static double moedasToDouble(Moeda... moedas) {

        BigDecimal valor = BigDecimal.ZERO;
        BigDecimal valorMoeda;

        for (Moeda moeda : moedas) {

            valorMoeda = BigDecimal.valueOf(moeda.getValor());

            valor = valor.add(valorMoeda);
        }

        return valor.doubleValue();
    }

    public static double moedasToDouble(QuantidadeMoeda... moedas) {

        return moedasToDouble(Arrays.asList(moedas));
    }

    public static double moedasToDouble(Iterable<QuantidadeMoeda> moedas) {

        BigDecimal valor = BigDecimal.ZERO;
        BigDecimal valorMoeda;

        for (QuantidadeMoeda qte : moedas) {

            valorMoeda = BigDecimal.valueOf(qte.getMoeda().getValor());

            valor = valor.add(
                valorMoeda.multiply(
                    BigDecimal.valueOf(qte.getQuantidade())));
        }

        return valor.doubleValue();
    }
}
