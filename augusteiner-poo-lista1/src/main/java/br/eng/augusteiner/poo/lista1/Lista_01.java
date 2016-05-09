
package br.eng.augusteiner.poo.lista1;

import static br.eng.augusteiner.poo.Util.invokeMain;
import static br.eng.augusteiner.poo.Util.questoes;

import java.util.Iterator;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Lista_01 {

    private static final Package PACKAGE = Lista_01.class.getPackage();

    /**
     * @param args
     */
    public static void main(String[] args) {

        Iterator<Class<?>> iter = questoes(PACKAGE);

        while (iter.hasNext()) {

            Class<?> questao = iter.next();

            invokeMain(
                questao,
                args);

            // println(c.getName());
        }
    }
}
