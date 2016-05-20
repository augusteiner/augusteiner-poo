
package br.eng.augusteiner.poo.soda.shell;

import java.io.IOException;

import com.budhash.cliche.Command;
import com.budhash.cliche.Shell;
import com.budhash.cliche.ShellFactory;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ConsumidorShell {

    public static final String PROGRAM_NAME = ConsumidorShell.class.getSimpleName();

    @Command(description = "Administrar máquina de refris")
    public void admin() throws IOException {

        AdminShell.start();
    }

    public static void start() throws IOException {

        Shell shell = ShellFactory.createConsoleShell(
            "$",
            PROGRAM_NAME,
            new ConsumidorShell());

        shell.commandLoop();
    }
}
