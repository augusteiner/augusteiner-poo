
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.Util.sysout;

import br.eng.augusteiner.poo.lista2.Contador;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q09_Modelo_Contador {

    public static void main(String[] ars) {

        Contador contador1 = new Contador(2);

        sysout(
            "Contador: %s",
            contador1.decrementar(false));

        sysout(
            "Contador: %s",
            contador1.decrementar(false));

        sysout(
            "Contador: %s",
            contador1);

        sysout(
            "Contador: %s",
            contador1.decrementar());
    }
}
