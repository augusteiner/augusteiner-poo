
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.Util.sysout;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Q33_Tabuada_Array_Bidimensional {

    public static void main(String[] args) {

        int[][] tabuada = new int[10][10];

        for (int i = 0; i < tabuada.length; i++) {

            for (int j = 0; j < tabuada[i].length; j++) {

                tabuada[i][j] = i + j;
            }
        }

        printTabuada(tabuada);
    }

    public static void printTabuada(int[][] tabuada) {

        for (int i = 0; i < tabuada.length; i++) {

            for (int j = 0; j < tabuada[i].length; j++) {

                sysout(
                    "%s + %s = %s",
                    i,
                    j,
                    tabuada[i][j]);
            }

            sysout();
        }
    }
}
