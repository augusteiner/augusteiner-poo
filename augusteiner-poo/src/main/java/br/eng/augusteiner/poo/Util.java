
package br.eng.augusteiner.poo;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Util {

    private static final Scanner scanner = new Scanner(System.in);

    public static void executarMain(
        Class<?> questao,
        String[] args) {

        try {

            Method m = questao.getMethod(
                "main",
                String[].class);

            println();
            println("---------------------------");
            println(questao.getSimpleName().replace("_", " "));
            println("---------------------------");

            m.invoke(null, (Object) args);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static Scanner getScanner() {

        return scanner;
    }

    public static double nextDouble() {

        return getScanner().nextDouble();
    }

    public static double nextInt() {

        return getScanner().nextInt();
    }

    public static void print(Object texto) {

        System.out.print(texto);
    }

    public static void println() {

        System.out.println();
    }

    public static void println(Object texto) {

        System.out.println(texto);
    }

    public static void println(
        String formato,
        Object... args) {

        System.out.println(String.format(
            formato,
            args));
    }

    public static Iterator<Class<?>> questoes(Package pkg) {

        Reflections ref = new Reflections(
            pkg.getName(),
            new SubTypesScanner(false));

        final Iterator<Object> iter = ref.getSubTypesOf(Object.class)
            .stream()
            .filter(new Predicate<Class<?>>(){

                public boolean test(Class<?> t) {

                    return t.getSimpleName()
                        .startsWith("Q");
                }
            })
            .sorted(new Comparator<Class<?>>(){

                public int compare(
                    Class<?> o1,
                    Class<?> o2) {

                    return o1.getSimpleName()
                        .compareTo(o2.getSimpleName());
                }
            })
            .collect(Collectors.toList())
            .iterator();

        return new Iterator<Class<?>>(){

            public boolean hasNext() {

                return iter.hasNext();
            }

            public Class<?> next() {

                return (Class<?>) iter.next();
            }
        };
    }
}
