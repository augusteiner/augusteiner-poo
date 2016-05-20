/**
 *
 */
package br.eng.augusteiner.poo.shell;

import java.io.IOException;

import com.budhash.cliche.Shell;
import com.budhash.cliche.ShellFactory;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    public static void main(String[] args) throws IOException {

        Shell shell = ShellFactory.createConsoleShell(
            "$",
            ConsumidorShell.PROGRAM_NAME,
            new ConsumidorShell());

        shell.commandLoop();
    }
}
