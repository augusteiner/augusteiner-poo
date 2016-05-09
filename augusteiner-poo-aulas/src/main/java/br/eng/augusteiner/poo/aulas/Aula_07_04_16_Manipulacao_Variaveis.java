
package br.eng.augusteiner.poo.aulas;

import java.io.PrintStream;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_07_04_16_Manipulacao_Variaveis {

    static final PrintStream out = System.out;

    public static void main(String[] args) {

        int a = 8;
        int b = 7;

        int c = a++;
        int d = ++b;

        println("a: %s", a);
        println("b: %s", b);
        println("c: %s", c);
        println("d: %s", d);
    }

    private static void println(
        String format,
        Object... args) {

        out.println(String.format(
            format,
            args));
    }
}
