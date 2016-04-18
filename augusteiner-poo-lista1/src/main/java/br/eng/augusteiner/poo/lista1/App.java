
package br.eng.augusteiner.poo.lista1;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {
    public static void main(String[] args) {
        q10();
    }

    private static void q10() {

        double interMax = 50;
        double interMin = 10;

        double num;
        double curr;

        int dentro = 0;
        int fora = 0;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {

            out.print(String.format("Entre com o %sº número: ", i + 1));
            num = scn.nextDouble();

            if (num >= interMin && num <= interMax) {
                dentro++;
            } else {
                fora++;
            }
        }

        out.println(String.format("%s números dentro e %s números fora do intervalo [%s, %s]", dentro, fora, interMin,
                interMax));

        scn.close();
    }

    private static void q9() {
        PrintStream out = System.out;

        for (int i = 1; i < 10; i++) {
            out.println(String.format("4 x %s = %s", i, 4 * i));
        }
    }

    private static void q8() {
        int fat = 1;
        int n;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        out.print("Informe o número para calcular o fatorial: ");
        n = scn.nextInt();

        for (int i = 1; i <= n; i++) {
            fat *= i;
        }

        out.println(String.format("%s! = %s", n, fat));
        scn.close();
    }

    private static void q7() {

        PrintStream out = System.out;

        for (int i = 1; i < 200; i++) {

            if (i % 7 == 0) {
                out.println(i);
            }
        }
    }

    private static void q6() {

        int soma = 0;

        PrintStream out = System.out;

        for (int i = 0; i < 100; i++) {
            soma += i;
        }

        out.println(String.format("A soma dos 100º números é: %s", soma));
    }

    private static void q5() {

        double[] precos = { 2.5, 12.5, 5.5, 7 };
        String[] pratos = { "VATAPÁ", "PIZZA", "MACARRONADA", "FEIJOADA" };
        int pratoSelecionado;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        for (int i = 0; i < pratos.length; i++) {
            out.println(String.format("%d %s \t(R$ %.2f)", i + 1, pratos[i], precos[i]));
        }

        out.println();

        out.println("Informe o prato desejado: ");
        pratoSelecionado = scn.nextInt() - 1;

        out.println(String.format("O preço do(a) %s é : R$ %.2f", pratos[pratoSelecionado], precos[pratoSelecionado]));

        scn.close();
    }

    private static void q4() {

        double salario;
        double desconto;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        out.print("Informe o salário: ");
        salario = scn.nextDouble();

        desconto = descontoPorSalario(salario);

        out.println(String.format("Desconto de R$ %.2f para o salário de R$ %.2f", desconto, salario));

        scn.close();
    }

    private static void q3() {

        double x1 = 0;
        double x2 = 0;

        double y1 = 0;
        double y2 = 0;

        double distancia;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        out.print("Informe x1: ");
        x1 = scn.nextDouble();

        out.print("Informe x2: ");
        x2 = scn.nextDouble();

        out.print("Informe y1: ");
        y1 = scn.nextDouble();

        out.print("Informe y2: ");
        y2 = scn.nextDouble();

        distancia = distanciaEntrePontos(x1, x2, y1, y2);

        out.println(String.format("A distância entre os pontos informados é: %f", distancia));

        scn.close();
    }

    public static void q2() {

        double maior = Integer.MIN_VALUE;
        double menor = Integer.MAX_VALUE;
        double curr;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            out.print(String.format("Informe o %sº número: ", i + 1));
            curr = scn.nextDouble();

            if (curr > maior) {
                maior = curr;
            }

            if (curr < menor) {
                menor = curr;
            }
        }

        out.println(String.format("O maior número é: %s", maior));

        out.println(String.format("O menor número é: %s", menor));

        scn.close();
    }

    public static void q1() {

        double x;
        double y;
        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        out.print("Informe um número: ");
        x = scn.nextDouble();

        out.print("Informe outro número: ");
        y = scn.nextDouble();

        if (x == y) {
            out.println("IGUAIS");
        } else {
            out.println("DIFERENTES");
        }

        scn.close();
    }

    private static double descontoPorSalario(double salario) {

        if (salario > 2000) {
            return salario * 0.3;
        } else if (salario > 1200) {
            return salario * 0.25;
        } else if (salario > 600) {
            return salario * 0.2;
        } else {
            return 0;
        }
    }

    private static double distanciaEntrePontos(double x1, double x2, double y1, double y2) {

        return sqrt(pow(x1 - y1, 2) + pow(x2 - y2, 2));
    }
}
