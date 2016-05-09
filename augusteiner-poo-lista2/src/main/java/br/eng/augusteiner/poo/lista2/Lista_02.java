
package br.eng.augusteiner.poo.lista2;

import static br.eng.augusteiner.poo.Util.questoes;
import static br.eng.augusteiner.poo.Util.invokeMain;

import java.util.Iterator;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Lista_02 {

    private static final Package PACKAGE = Lista_02.class.getPackage();

    /**
     * @param args
     */
    public static void main(String[] args) {

        Iterator<Class<?>> iter = questoes(PACKAGE);

        while (iter.hasNext()) {

            Class<?> q = iter.next();

            invokeMain(q, args);
        }
    }
}
