
package br.eng.augusteiner.poo.lista1;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q01_Ler_2_Numeros_e_Imprimir_Iguais_ou_Diferentes {

    /**
     * @param args
     */
    public static void main(String[] args) {

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
}
