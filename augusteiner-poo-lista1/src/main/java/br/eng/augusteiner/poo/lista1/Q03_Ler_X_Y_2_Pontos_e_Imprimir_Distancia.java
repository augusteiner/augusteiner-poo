
package br.eng.augusteiner.poo.lista1;

import static br.eng.augusteiner.poo.Util.getScanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q03_Ler_X_Y_2_Pontos_e_Imprimir_Distancia {

    public static void main(String[] args) {

        double x1 = 0;
        double x2 = 0;

        double y1 = 0;
        double y2 = 0;

        double distancia;

        PrintStream out = System.out;
        Scanner scn = getScanner();

        out.print("Informe x1: ");
        x1 = scn.nextDouble();

        out.print("Informe x2: ");
        x2 = scn.nextDouble();

        out.print("Informe y1: ");
        y1 = scn.nextDouble();

        out.print("Informe y2: ");
        y2 = scn.nextDouble();

        distancia = distanciaEntrePontos(
            x1,
            x2,
            y1,
            y2);

        out.println(String.format(
            "A distância entre os pontos informados é: %f",
            distancia));

        // scn.close();
    }

    private static double distanciaEntrePontos(
        double x1,
        double x2,
        double y1,
        double y2) {

        return sqrt(pow(x1 - y1, 2) + pow(x2 - y2, 2));
    }
}
