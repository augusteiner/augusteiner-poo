
package br.eng.augusteiner.poo.soda;

import static br.eng.augusteiner.poo.Moeda.*;

import java.util.Arrays;

import br.eng.augusteiner.poo.Moeda;
import br.eng.augusteiner.poo.QuantidadeMoeda;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Util {

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

        double valor = 0;

        for (Moeda moeda : moedas) {

            valor += moeda.getValor();
        }

        return valor;
    }

    public static double moedasToDouble(QuantidadeMoeda... moedas) {

        return moedasToDouble(Arrays.asList(moedas));
    }

    public static double moedasToDouble(Iterable<QuantidadeMoeda> moedas) {

        double valor = 0;

        for (QuantidadeMoeda moeda : moedas) {

            valor += moeda.getValor();
        }

        return valor;
    }
}
