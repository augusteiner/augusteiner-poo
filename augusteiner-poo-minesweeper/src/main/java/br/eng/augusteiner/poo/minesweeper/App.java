
package br.eng.augusteiner.poo.minesweeper;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {
    // private static PrintStream out = System.out;

    public static void main(String[] args) {

        char[][] campo = null;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        campo = iniciarCampo(9, 8);
        adicionarBombasPseudoAleatorias(campo);
        numerarBombasProximas(campo);

        imprimirCampo(out, campo);
    }

    private static void numerarBombasProximas(char[][] field) {

        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field[i].length; j++) {

                // XXX se tem uma bomba
                if (field[i][j] == '*') {

                    // XXX scaneando a matriz 3x3 ao redor da bomba
                    for (int z = max(i - 1, 0); z < min(i + 2, field.length); z++) {

                        for (int w = max(j - 1, 0); w < min(j + 2, field[i].length); w++) {

                            if (field[z][w] == '*') {

                            } else {
                                field[z][w] += 1;
                            }

                            // out.print(String.format("[%s, %s]", z, w));
                        }
                    }

                    // out.println();
                }
            }
        }

        // out.println();
    }

    private static void adicionarBombasPseudoAleatorias(char[][] campo) {

        campo[2][3] = '*';
        campo[3][4] = '*';
        campo[4][3] = '*';
        campo[5][5] = '*';
        campo[6][2] = '*';
    }

    private static void imprimirCampo(PrintStream out, char[][] campo) {

        char charOut;

        for (int i = 0; i < campo.length; i++) {

            for (int j = 0; j < campo[i].length; j++) {

                charOut = campo[i][j] == '0' ? '.' : campo[i][j];

                out.print(charOut + "  ");
            }

            out.println();
        }
    }

    private static char[][] iniciarCampo(int linhas, int colunas) {

        char campo[][] = new char[linhas][colunas];

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                campo[i][j] = '0';
            }
        }

        return campo;
    }
}
