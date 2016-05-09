
package br.eng.augusteiner.poo.lista1;

import java.io.PrintStream;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q09_Imprimir_Tabuada_Numero_4 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        PrintStream out = System.out;

        for (int i = 1; i < 10; i++) {

            out.println(String.format(
                "4 x %s = %s",
                i,
                4 * i));
        }
    }
}
