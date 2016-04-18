package br.eng.augusteiner.poo.minesweeper;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        char[][] field = initField(5, 5);
        boolean gameOver = false;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        while (!gameOver) {
            printField(out, field);

            scn.next();
        }
    }

    private static void printField(PrintStream out, char[][] fields) {

        for (int i = 0; i < fields.length; i++) {

            for (int j = 0; j < fields[0].length; j++) {

                out.print(fields[i][j] + "  ");
            }

            out.println();
        }
    }

    private static char[][] initField(int rows, int cols) {

        return initField(rows, cols, rows + cols);
    }

    private static char[][] initField(int rows, int cols, int bombs) {

        char field[][] = new char[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                field[i][j] = '*';
            }
        }

        return field;
    }
}
