
package br.eng.augusteiner.poo.lista1;

import static br.eng.augusteiner.poo.Util.println;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    public static void main(String[] args) {

        Reflections ref = new Reflections(
            App.class.getPackage().getName(),
            new SubTypesScanner(false));

        List<?> list = ref.getSubTypesOf(Object.class)
            .stream()
            .filter(new Predicate<Class<?>>(){

                public boolean test(Class<?> t) {

                    return t.getSimpleName().startsWith("Q");
                }
            })
            .sorted(new Comparator<Class<?>>(){

                public int compare(Class<?> o1, Class<?> o2) {

                    return o1.getSimpleName().compareTo(o2.getSimpleName());
                }
            })
            .collect(Collectors.toList());

        for (Object i : list) {

            Class<?> c = (Class<?>)i;

            try {
                Method m = c.getMethod("main", String[].class);

                println();
                println("---------------------------");
                println(c.getSimpleName().replace("_", " "));
                println("---------------------------");

                m.invoke(null, (Object)args);
            } catch (Exception e) {

                e.printStackTrace();
            }

            // println(c.getName());
        }
    }
}
