
package br.eng.augusteiner.poo.aulas;

import java.util.ArrayList;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_11_04_16_FOR_e_IF {

    public static void main(String[] args) {

        boolean teste = true;

        if (teste) {

            System.out.println("True");
        } else {

            System.out.println("False");
        }

        int x = 9;

        if (ehPar(x)) {

            System.out.println(String.format(
                "%s é %s",
                x,
                "par"));
        } else {

            System.out.println(String.format(
                "%s é %s",
                x,
                "ímpar"));
        }

        multiplosDe(4, false);
        multiplosDe(4, true);

        int num = 9;
        Integer[] divisores = divisoresDe(num);

        if (divisores.length == 2) {

            System.out.println(String.format(
                "%s é primo",
                num));
        } else {

            System.out.println(String.format(
                "%s não é primo, pois é divisível por %s",
                num,
                divisores[1]));
        }
    }

    private static boolean ehPar(int num) {

        return num % 2 == 0;
    }

    private static void multiplosDe(
        int num,
        boolean dumb) {

        if (dumb) {

            for (int i = 4; i <= 200; i++) {

                if (i % 4 == 0) {

                    System.out.println(i);
                }
            }
        } else {

            multiplosDe(num);
        }
    }

    private static void multiplosDe(int num) {

        for (int i = num; i <= 200; i += num) {

            System.out.println(i);
        }
    }

    public static Integer[] divisoresDe(int num) {

        return divisoresDe(num, true);
    }

    public static Integer[] divisoresDe(
        int num,
        boolean pararNaPrimeiraOcorrencia) {

        ArrayList<Integer> divisores = new ArrayList<Integer>();

        divisores.add(1);

        for (int i = 2; i <= num / 2; i++) {

            if (num % i == 0) {
                // divisor = i;
                divisores.add(i);

                if (pararNaPrimeiraOcorrencia) {
                    // Não é necessário mais procurar
                    break;
                }
            }
        }

        divisores.add(num);

        return divisores.toArray(new Integer[divisores.size()]);
    }
}
