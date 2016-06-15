
package br.eng.augusteiner.poo.aulas;

import java.util.Scanner;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_16_06_11_Exceptions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i = 0;

        Integer n = null;
        String line = null;

        while (n == null) {

            System.out.print("Informe um número: ");

            line = sc.nextLine();

            try {

                n = Integer.parseInt(line);

                System.out.println("Número lido com sucesso!");

                System.out.println(1 / 0);

            } catch (ArithmeticException e) {

                System.out.println(e.getMessage());

            } catch (NumberFormatException e) {

                System.out.println("Informe um número válido!");

                System.out.println(e.getMessage());

            } finally {

                System.out.println(String.format(
                    "Tentativa # %d",
                    i++));
            }

        }

        sc.close();
    }
}
