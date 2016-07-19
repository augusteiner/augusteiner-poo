
package generics.aula;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Generics_04_Wildcards {

    public static Collection<?> listaCuringa() {

        Collection<String> lista = new ArrayList<String>();

        lista.add("1ª string");
        lista.add("2ª string");

        return lista;
    }

    public static void main(String[] args) {

        Collection<?> listaGenerica = listaCuringa();

        // XXX Não se sabe de que tipo é a lista
        //listaGenerica.add("except");

        for (Object o : listaGenerica) {

            sysout(o);
        }
    }

    public static void sysout(Object o) { System.out.println(o); }
}
