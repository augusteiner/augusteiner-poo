
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.Util.println;

import br.eng.augusteiner.poo.lista2.classes.Contador;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q09_Modelo_Contador {

    public static void main(String[] ars) {

        Contador contador1 = new Contador(2);

        println(
            "Contador: %s",
            contador1.decrementar(false));

        println(
            "Contador: %s",
            contador1.decrementar(false));

        println(
            "Contador: %s",
            contador1);

        println(
            "Contador: %s",
            contador1.decrementar());
    }
}
