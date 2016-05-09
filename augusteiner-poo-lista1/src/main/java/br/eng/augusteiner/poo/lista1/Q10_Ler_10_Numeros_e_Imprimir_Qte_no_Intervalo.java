
package br.eng.augusteiner.poo.lista1;

import static br.eng.augusteiner.poo.Util.getScanner;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q10_Ler_10_Numeros_e_Imprimir_Qte_no_Intervalo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        final double intervaloMax = 50;
        final double intervaloMin = 10;

        double num;

        int dentro = 0;
        int fora = 0;

        PrintStream out = System.out;
        Scanner scn = getScanner();

        for (int i = 0; i < 10; i++) {

            out.print(String.format(
                "Entre com o %sº número: ",
                i + 1));
            num = scn.nextDouble();

            if (num >= intervaloMin &&
                num <= intervaloMax) {

                dentro++;
            } else {

                fora++;
            }
        }

        out.println(String.format(
            "%s números dentro e %s números fora do intervalo [%s, %s]",
            dentro,
            fora,
            intervaloMin,
            intervaloMax));

        // scn.close();
    }
}
