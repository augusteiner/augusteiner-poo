
package br.eng.augusteiner.poo.lista2;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Util {

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
