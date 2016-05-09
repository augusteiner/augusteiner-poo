
package br.eng.augusteiner.poo.lista1;

import static br.eng.augusteiner.poo.Util.getScanner;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q08_Ler_Numero_e_Imprimir_Fatorial {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int fat = 1;
        int n;

        PrintStream out = System.out;
        Scanner scn = getScanner();

        out.print("Informe o número para calcular o fatorial: ");
        n = scn.nextInt();

        for (int i = 1; i <= n; i++) {

            fat *= i;
        }

        out.println(String.format(
            "%s! = %s",
            n,
            fat));
        // scn.close();
    }
}
