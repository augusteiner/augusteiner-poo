
package br.eng.augusteiner.poo.maq;

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
