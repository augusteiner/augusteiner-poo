
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.Util.sysout;

import br.eng.augusteiner.poo.lista2.Autor;
import br.eng.augusteiner.poo.lista2.Livro;

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

        sysout(
            "Livro 1: %s",
            livro1);
    }
}
