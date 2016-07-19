
package generics.aula;

import java.util.ArrayList;
import java.util.List;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Generics_05_Extends_Covariancia {

    public static <T> List<T> novaListaGenerica() {

        return new ArrayList<T>();
    }

    public static List<? extends String> novaLista() {

        List<String> lista = novaListaGenerica();

        return lista;
    }

    public static void main(String[] args) {

        List<? extends String> listaDeStrings = novaLista();

        //listaDeStrings.add("1ª string");
        //listaDeStrings.add("2ª string");

        List<? extends Object> listaDeObjetos = listaDeStrings;

        for (String s : listaDeStrings) {

            System.out.println(s);
        }
    }
}
