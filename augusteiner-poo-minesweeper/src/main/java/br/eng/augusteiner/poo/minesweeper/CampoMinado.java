
package br.eng.augusteiner.poo.minesweeper;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.PrintStream;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class CampoMinado {

    public static final byte BYTE_BOMB = '*';
    public static final byte BYTE_ZERO = '0';
    public static final byte BYTE_XDOT = '.';

    public static void main(String[] args) {

        byte[][] campo = null;

        PrintStream out = System.out;

        campo = gerarCampo(9, 8);
        adicionarBombasPseudoAleatorias(campo);
        numerarProximidadeBombas(campo);

        imprimirCampo(out, campo);
    }

    public static void numerarProximidadeBombas(byte[][] field) {

        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field[i].length; j++) {

                // XXX se tem uma bomba
                if (field[i][j] == BYTE_BOMB) {

                    final int iMin = max(i - 1, 0);
                    final int iMax = min(i + 2, field.length);

                    final int jMin = max(j - 1, 0);
                    final int jMax = min(j + 2, field[i].length);

                    // XXX scaneando a matriz 3x3 ao redor da bomba
                    for (int z = iMin; z < iMax; z++) {

                        for (int w = jMin; w < jMax; w++) {

                            if (field[z][w] == BYTE_BOMB) {

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

    private static void adicionarBombasPseudoAleatorias(byte[][] campo) {

        campo[2][3] = BYTE_BOMB;
        campo[3][4] = BYTE_BOMB;
        campo[4][3] = BYTE_BOMB;
        campo[5][5] = BYTE_BOMB;
        campo[6][2] = BYTE_BOMB;
    }

    public static void imprimirCampo(PrintStream out, byte[][] campo) {

        byte outChar;
        byte[] outString = new byte[1];

        for (int i = 0; i < campo.length; i++) {

            for (int j = 0; j < campo[i].length; j++) {

                outChar = campo[i][j] == BYTE_ZERO ? BYTE_XDOT : campo[i][j];

                outString[0] = outChar;
                out.print(String.format(
                    " %s ",
                    new String(outString)));
            }

            out.println();
        }
    }

    public static byte[][] gerarCampo(int linhas, int colunas) {

        byte campo[][] = new byte[linhas][colunas];

        for (int i = 0; i < linhas; i++) {

            for (int j = 0; j < colunas; j++) {

                campo[i][j] = BYTE_ZERO;
            }
        }

        return campo;
    }
}
