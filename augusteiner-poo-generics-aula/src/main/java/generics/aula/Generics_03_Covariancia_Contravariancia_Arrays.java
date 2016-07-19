
package generics.aula;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Generics_03_Covariancia_Contravariancia_Arrays {

    // TODO Em qual linha deste método há um erro?
    public static void main(String[] args) {

        String[] arrayDeStrings = new String[] {
            "1ª string", "2ª string" };

        Object[] arrayDeObjects = arrayDeStrings;

        arrayDeObjects[0] = 1;

        for (Object o : arrayDeObjects) {

            System.out.println(o);
        }
    }
}
