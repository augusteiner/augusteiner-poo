
package br.eng.augusteiner.poo.aulas;

import java.util.ArrayList;

public class Aula1 {
    public static void main(String[] args) {
        boolean test = true;

        if (test) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        int x = 9;

        if (isPar(x)) {
            System.out.println(String.format("%s é %s", x, "par"));
        } else {
            System.out.println(String.format("%s é %s", x, "ímpar"));
        }

        multiplesOf(4, false);
        multiplesOf(4, true);

        int num = 9;
        Integer[] divisores = isPrimeNumber(num);

        if (divisores.length == 2) {
            System.out.println(String.format("%s é primo", num));
        } else {
            System.out.println(String.format("%s não é primo, pois é divisível por %s", num, divisores[1]));
        }
    }

    private static boolean isPar(int num) {
        return num % 2 == 0;
    }

    private static void multiplesOf(int num, boolean dumb) {
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

    public static Integer[] isPrimeNumber(int num) {
        return isPrimeNumber(num, true);
    }

    public static Integer[] isPrimeNumber(int num, boolean stopOnFirst) {
        ArrayList<Integer> divisores = new ArrayList<Integer>();

        divisores.add(1);

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                // divisor = i;
                divisores.add(i);

                if (stopOnFirst) {
                    // Não é necessário mais procurar
                    break;
                }
            }
        }

        divisores.add(num);

        return divisores.toArray(new Integer[divisores.size()]);
    }
}
