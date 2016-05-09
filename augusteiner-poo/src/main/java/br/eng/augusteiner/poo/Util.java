
package br.eng.augusteiner.poo;

import java.lang.Object;
import java.util.Scanner;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Util {

    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {

        return scanner;
    }

    public static double nextDouble() {

        return getScanner().nextDouble();
    }

    public static double nextInt() {

        return getScanner().nextInt();
    }

    public static void println() {

        println("");
    }

    public static void println(Object texto) {

        System.out.println(texto);
    }

    public static void println(
        String formato,
        Object... args) {

        System.out.println(String.format(
            formato,
            args));
    }
}
