
package br.eng.augusteiner.poo.soda.shell;

import com.budhash.cliche.Command;
import com.budhash.cliche.Param;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class AdminShell {

    public static final String PROGRAM_NAME = AdminShell.class.getSimpleName();

    @Command
    public void addRefri(
        @Param(name = "Código", description = "Código do Refrigerante")
            String codigo,
        @Param(name = "Qte", description = "Quantas unidades do Refrigerante")
            int qte) {

        System.out.println(String.format(
            "Adicionado %s %s ao estoque",
            qte,
            codigo));
    }
}
