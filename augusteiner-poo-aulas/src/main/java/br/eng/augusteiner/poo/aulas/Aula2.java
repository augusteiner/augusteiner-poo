
package br.eng.augusteiner.poo.aulas;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula2 {

    public static void main(String[] args) {

        int a = 8;
        int b = 7;

        int c = a++;
        int d = ++b;

        System.out.println(String.format("a: %s", a));
        System.out.println(String.format("b: %s", b));
        System.out.println(String.format("c: %s", c));
        System.out.println(String.format("d: %s", d));
    }
}
