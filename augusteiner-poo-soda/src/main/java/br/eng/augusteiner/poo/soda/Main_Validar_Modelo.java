
package br.eng.augusteiner.poo.soda;

import static br.eng.augusteiner.poo.Util.println;
import static br.eng.augusteiner.poo.soda.Util.moedasToString;

import br.eng.augusteiner.poo.Moeda;
import br.eng.augusteiner.poo.Produto;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Main_Validar_Modelo {

    public static void main(String[] args) {

        Produto coca = new Produto(
            "5aas12-adf456-asdf546-asdf3213",
            "Coca Cola 200ml",
            2.50);

        Produto fanta = new Produto(
            "5df512-asf456-asdf546-asdf4654",
            "Fanta 200ml",
            2.10);

        Moeda m25 = Moeda.doValor(0.25);
        Moeda m10 = Moeda.doValor(0.10);

        fanta.setPreco(coca.getPreco());

        println(coca);
        println(fanta);

        println(m25);
        println(m10);

        println(moedasToString(
            m25,
            m10));
    }
}
