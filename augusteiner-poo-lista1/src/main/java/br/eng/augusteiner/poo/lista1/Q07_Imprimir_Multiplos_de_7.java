
package br.eng.augusteiner.poo.lista1;

import java.io.PrintStream;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q07_Imprimir_Multiplos_de_7 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        PrintStream out = System.out;

        for (int i = 1; i < 200; i++) {

            if (i % 7 == 0) {
                out.println(i);
            }
        }
    }
}
