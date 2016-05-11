
package br.eng.augusteiner.poo.minesweeper;

import static br.eng.augusteiner.poo.minesweeper.CampoMinado.BYTE_BOMB;
import static br.eng.augusteiner.poo.minesweeper.CampoMinado.gerarCampo;
import static br.eng.augusteiner.poo.minesweeper.CampoMinado.imprimirCampo;
import static br.eng.augusteiner.poo.minesweeper.CampoMinado.numerarProximidadeBombas;

import java.util.Random;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class CampoMinadoAleatorio {

    /**
     * @param args
     */
    public static void main(String[] args) {

        byte[][] campo = gerarCampoComBombasAleatorias(
            10,
            10,
            10);

        numerarProximidadeBombas(campo);

        imprimirCampo(
            System.out,
            campo);
    }

    private static byte[][] gerarCampoComBombasAleatorias(
        int rows,
        int cols,
        int numeroBombas) {

        int max = rows * cols;
        int c;
        int i;
        int j;

        byte[][] campo = gerarCampo(
            rows,
            cols);

        while (numeroBombas-- > 0) {
            Random r = new Random();
            c = r.nextInt(max);

            // System.out.println(String.format("Random: %s", c));
            // System.out.println(c / rows);

            i = c / rows;
            j = c % rows;

            // System.out.println(String.format("i: %s", i));
            // System.out.println(String.format("j: %s", j));

            campo[i][j] = BYTE_BOMB;
        }

        return campo;
    }
}
