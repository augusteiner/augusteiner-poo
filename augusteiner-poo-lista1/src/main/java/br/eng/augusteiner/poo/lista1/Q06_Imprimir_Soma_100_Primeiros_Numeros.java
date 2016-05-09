
package br.eng.augusteiner.poo.lista1;

import java.io.PrintStream;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q06_Imprimir_Soma_100_Primeiros_Numeros {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int soma = 0;

        PrintStream out = System.out;

        for (int i = 0; i < 100; i++) {
            soma += i;
        }

        out.println(String.format(
            "A soma dos 100º números é: %s",
            soma));
    }
}
