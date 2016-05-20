
package br.eng.augusteiner.poo.soda.shell;

import java.io.IOException;

import com.budhash.cliche.Command;
import com.budhash.cliche.Param;
import com.budhash.cliche.ShellFactory;

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

    public static void start() throws IOException {

        ShellFactory.createConsoleShell(
            "#",
            PROGRAM_NAME,
            new AdminShell()).commandLoop();
    }
}
