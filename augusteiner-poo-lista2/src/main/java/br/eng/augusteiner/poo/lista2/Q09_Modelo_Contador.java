
package br.eng.augusteiner.poo.lista2;

import static br.eng.augusteiner.poo.Util.println;

import br.eng.augusteiner.poo.Contador;

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
