
package generics.aula;

import java.util.ArrayList;
import java.util.List;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Generics_06_Super_Contravariancia {

    public static <T> List<T> novaListaGenerica() {

        return new ArrayList<T>();
    }

    public static List<? super String> novaListaDeStrings() {

        return novaListaGenerica();
    }

    public static void main(String[] args) {

        List<? super String> lista = novaListaDeStrings();

        lista.add("1ª string");
        lista.add("2ª string");

        //for (String s : lista) {
        for (Object s : lista) {

            System.out.println(s);
        }
    }
}
