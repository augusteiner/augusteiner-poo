
package br.eng.augusteiner.poo.aulas;

import br.eng.augusteiner.poo.Lampada;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_16_05_16_Membros_Static_e_Final {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(Lampada.getPotencia());

        System.out.println(String.format(
            "Quantidade de Parâmetros: %d",
            args.length));

        for (int i = 0; i < args.length; i++) {

            System.out.println(args[i]);
        }
    }
}
