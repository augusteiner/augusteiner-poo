
package br.eng.augusteiner.poo.maq;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    public static void main(String[] args) {

        Produto coca = new Produto(
            "5aas12-adf456-asdf546-asdf3213",
            "Coca Cola 200ml",
            "Refrigerante de cola",
            2.50);

        Produto fanta = new Produto(
            "5df512-asf456-asdf546-asdf4654",
            "Fanta 200ml",
            "Refrigerante de laranja",
            2.10);

        Moeda m25 = new Moeda(
            0.25,
            "vinte e cinco centavos");
        Moeda m10 = new Moeda(
            0.10,
            "dez centavos");

        fanta.setPreco(coca.getPreco());

        System.out.println(coca);
        System.out.println(fanta);

        System.out.println(m25);
        System.out.println(m10);
    }
}
