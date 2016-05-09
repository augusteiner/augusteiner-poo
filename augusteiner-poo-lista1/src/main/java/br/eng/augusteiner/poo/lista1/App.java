
package br.eng.augusteiner.poo.lista1;

import static br.eng.augusteiner.poo.Util.invokeMain;
import static br.eng.augusteiner.poo.Util.questoes;

import java.util.Iterator;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    private static final Package PACKAGE = App.class.getPackage();

    /**
     * @param args
     */
    public static void main(String[] args) {

        Iterator<Class<?>> iter = questoes(PACKAGE);

        while (iter.hasNext()) {

            Class<?> c = iter.next();

            invokeMain(c, args);

            // println(c.getName());
        }
    }
}