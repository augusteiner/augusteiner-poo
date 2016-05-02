
package br.eng.augusteiner.poo.soda;

import br.eng.augusteiner.poo.soda.classes.Moeda;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Util {

    public static double moedasToDouble(Moeda... moedas) {

        double valor = 0;

        for (int i = 0; i < moedas.length; i++) {

            valor += moedas[i].getValor();
        }

        return valor;
    }
}
