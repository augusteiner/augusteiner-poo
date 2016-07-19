
package generics.aula;

import java.util.ArrayList;
import java.util.List;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Generics_04_Extends_Covariancia {

    public static <T> List<T> novaListaGenerica() {

        return new ArrayList<T>();
    }

    public static List<? extends String> novaLista() {

        List<String> lista = novaListaGenerica();

        return lista;
    }

    public static void main(String[] args) {

        List<? extends String> listaDeStrings = novaLista();

        List<? extends Object> listaDeObjetos = listaDeStrings;

        // listaDeStrings.add("1ª string");
        // listaDeStrings.add("2ª string");

        for (Object s : listaDeObjetos) {

            System.out.println(s);
        }
    }
}
