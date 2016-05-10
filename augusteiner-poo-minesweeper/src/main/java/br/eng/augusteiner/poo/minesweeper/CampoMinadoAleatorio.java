
package br.eng.augusteiner.poo.minesweeper;

import java.util.Arrays;
import java.util.Random;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class CampoMinadoAleatorio {

    /**
     * @param args
     */
    public static void main(String[] args) {

        byte[][] campo = gerarCampoMinado(
            10,
            10,
            10);

        App.numerarProximidadeBombas(campo);

        App.imprimirCampo(
            System.out,
            campo);
    }

    private static byte[][] gerarCampoMinado(
        int nBombs,
        int rows,
        int cols) {

        int max = rows * cols;
        int c;
        int i;
        int j;
        byte[][] campo = App.iniciarCampo(
            rows,
            cols);

        while (nBombs-- > 0) {
            Random r = new Random();
            c = r.nextInt(max);

            // System.out.println(String.format("Random: %s", c));
            // System.out.println(c / rows);

            i = c / rows;
            j = c % rows;

            // System.out.println(String.format("i: %s", i));
            // System.out.println(String.format("j: %s", j));

            campo[i][j] = App.BYTE_BOMB;
        }

        return campo;
    }
}
