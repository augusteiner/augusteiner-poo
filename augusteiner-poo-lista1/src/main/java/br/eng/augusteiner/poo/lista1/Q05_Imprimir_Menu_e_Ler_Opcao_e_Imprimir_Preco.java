
package br.eng.augusteiner.poo.lista1;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q05_Imprimir_Menu_e_Ler_Opcao_e_Imprimir_Preco {

    public static void main(String[] args) {

        double[] precos = {
            2.5,
            12.5,
            5.5,
            7 };
        String[] pratos = {
            "VATAPÁ",
            "PIZZA",
            "MACARRONADA",
            "FEIJOADA" };
        int pratoSelecionado;

        PrintStream out = System.out;
        Scanner scn = new Scanner(System.in);

        for (int i = 0; i < pratos.length; i++) {

            out.println(String.format(
                "%d %s \t(R$ %.2f)",
                i + 1,
                pratos[i],
                precos[i]));
        }

        out.println();

        out.println("Informe o prato desejado: ");
        pratoSelecionado = scn.nextInt() - 1;

        out.println(String.format(
            "O preço do(a) %s é : R$ %.2f",
            pratos[pratoSelecionado],
            precos[pratoSelecionado]));

        scn.close();
    }
}
