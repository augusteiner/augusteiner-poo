
package br.eng.augusteiner.poo.lista1;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q04_Ler_Salario_e_Imprimir_Desconto {

    /**
     * @param args
     */
    public static void main(String[] args) {

        double salario;
        double desconto;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        out.print("Informe o salário: ");
        salario = scn.nextDouble();

        desconto = descontoPorSalario(salario);

        out.println(String.format(
            "Desconto de R$ %.2f para o salário de R$ %.2f",
            desconto,
            salario));

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
}
