
package br.eng.augusteiner.poo.shell;

import java.io.IOException;

import com.budhash.cliche.Command;
import com.budhash.cliche.ShellFactory;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ConsumidorShell {

    public static final String PROGRAM_NAME = ConsumidorShell.class.getSimpleName();

    @Command(description = "Administrar máquina de refris")
    public void admin() throws IOException {

        ShellFactory.createConsoleShell(
            "#",
            AdminShell.PROGRAM_NAME,
            new AdminShell()).commandLoop();
    }
}
