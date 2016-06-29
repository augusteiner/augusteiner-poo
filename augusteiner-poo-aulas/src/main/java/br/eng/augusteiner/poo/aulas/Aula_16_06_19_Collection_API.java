
package br.eng.augusteiner.poo.aulas;

import br.eng.augusteiner.poo.AgendaShell;
import br.eng.augusteiner.poo.IAgenda;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_16_06_19_Collection_API {

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {

            System.out.println("Argumento class deve ser fornecido.");

            return;
        }

        IAgenda agenda;

        try {

            Class<?> cls = Class.forName(args[0]);

            if (IAgenda.class.isAssignableFrom(cls)) {

                agenda = (IAgenda) cls.newInstance();
            } else {

                System.out.println("Argumento class deve ser válido.");
                return;
            }

        } catch (Exception e) {

            e.printStackTrace();

            throw e;
        }

        AgendaShell.iniciar(agenda);
    }
}
