
package br.eng.augusteiner.poo.lista1;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 *
 */
public class Q02_Ler_5_Numeros_e_Imprimir_Maior_e_Menor {

    /**
     * @param args
     */
    public static void main(String[] args) {

        double maior = Integer.MIN_VALUE;
        double menor = Integer.MAX_VALUE;
        double curr;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            out.print(String.format("Informe o %sº número: ", i + 1));
            curr = scn.nextDouble();

            if (curr > maior) {
                maior = curr;
            }

            if (curr < menor) {
                menor = curr;
            }
        }

        out.println(String.format(
            "O maior número é: %s",
            maior));

        out.println(String.format(
            "O menor número é: %s",
            menor));

        scn.close();
    }
}
