
package br.eng.augusteiner.poo.soda;

import static br.eng.augusteiner.poo.Moeda.LOCALE_PADRAO;
import static br.eng.augusteiner.poo.Moeda.SIMBOLO;

import br.eng.augusteiner.poo.Moeda;

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

        for (int i = 0; i < moedas.length; i++) {

            valor += moedas[i].getValor();
        }

        return valor;
    }
}
