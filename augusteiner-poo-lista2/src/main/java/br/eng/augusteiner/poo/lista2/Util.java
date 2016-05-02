
package br.eng.augusteiner.poo.lista2;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Util {

    public static void sysout() {

        System.out.println();
    }

    public static void sysout(Object texto) {

        System.out.println(texto);
    }

    public static void sysout(
        String formato,
        Object... args) {

        System.out.println(String.format(
            formato,
            args));
    }
}
