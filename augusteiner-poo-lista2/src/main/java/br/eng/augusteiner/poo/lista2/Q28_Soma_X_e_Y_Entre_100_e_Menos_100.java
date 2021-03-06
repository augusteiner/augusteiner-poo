
package br.eng.augusteiner.poo.lista2;

import static br.eng.augusteiner.poo.Util.println;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Q28_Soma_X_e_Y_Entre_100_e_Menos_100 {

    public static void main(String[] args) {

        for (int x = -100; x <= 100; x++) {

            for (int y = -100; y <= 100; y++) {

                if (x + y == -100 ||
                    x+ y == 100) {

                    println(
                        "x: %s, y: %s ~> x + y = %s",
                        x,
                        y,
                        x + y);
                }
            }
        }
    }
}
