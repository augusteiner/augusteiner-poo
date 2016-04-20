
package br.eng.augusteiner.poo.maq;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    public static void main(String[] args) {

        Produto p1 = new Produto(
            "5aas12-adf456-asdf546-asdf3213",
            "Coca Cola 200ml",
            "Refrigerante de cola",
            2.50);

        Produto p2 = new Produto(
            "5df512-asf456-asdf546-asdf4654",
            "Fanta 200ml",
            "Refrigerante de laranja",
            2.10);

        p2.setPreco(p1.getPreco());

        System.out.println(p1);
        System.out.println(p2);
    }
}
