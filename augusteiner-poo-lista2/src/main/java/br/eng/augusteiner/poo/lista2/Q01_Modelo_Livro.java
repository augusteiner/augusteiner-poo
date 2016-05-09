
package br.eng.augusteiner.poo.lista2;

import static br.eng.augusteiner.poo.Util.println;

import br.eng.augusteiner.poo.Autor;
import br.eng.augusteiner.poo.Livro;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q01_Modelo_Livro {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Autor autor1 = new Autor(
            "Nascimento",
            "José Augusto de Araújo");
        Livro livro1 = new Livro(
            autor1,
            2016,
            5,
            "Como criar classes em Java");

        println(
            "Livro 1: %s",
            livro1);
    }
}
