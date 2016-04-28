
package br.eng.augusteiner.poo.lista2;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    public static void main(String[] args) {

        Autor a1 = new Autor("Nascimento", "José Augusto de Araújo");
        Livro l1 = new Livro(a1, 2016, 5, "Como criar classes em Java");

        System.out.println(l1);

        EquacaoSegundoGrau eq1 = new EquacaoSegundoGrau(1, -6, -27);
        double raizes[] = eq1.raizes();

        System.out.println(String.format("%s ~> (x1: %s, x2: %s)", eq1, raizes[0], raizes[1]));

        Contador c1 = new Contador(2);

        System.out.println(c1.decrementar(false));

        System.out.println(c1.decrementar(false));
        System.out.println(c1);

        System.out.println(c1.decrementar());
    }
}
