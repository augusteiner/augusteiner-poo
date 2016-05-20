
package br.eng.augusteiner.poo.soda.shell;

import static br.eng.augusteiner.poo.Util.println;

import java.io.IOException;

import com.budhash.cliche.Command;
import com.budhash.cliche.Param;
import com.budhash.cliche.Shell;
import com.budhash.cliche.ShellFactory;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ConsumidorShell {

    public static final String PROGRAM_NAME = ConsumidorShell.class.getSimpleName();

    @Command(
        description = "Administrar máquina de refris",
        abbrev = "admin",
        name = "admin")
    public void admin() throws IOException {

        AdminShell.start();
    }

    @Command(
        description = "Inserir moeda",
        abbrev = "m1",
        name = "m1")
    public void inserirMoeda1() {

        inserirMoeda(1);
    }

    @Command(
        description = "Inserir moeda",
        abbrev = "m50",
        name = "m50")
    public void inserirMoeda50() {

        inserirMoeda(0.50);
    }

    @Command(
        description = "Inserir moeda",
        abbrev = "m5",
        name = "m5")
    public void inserirMoeda5(
        @Param(name = "qte", description = "Qte de moedas de R$ 0.05 a inserir")
        int count) {

        inserirMoeda(0.05, count);
    }

    @Command(
        description = "Inserir moeda",
        abbrev = "m5",
        name = "m5")
    public void inserirMoeda5() {

        inserirMoeda(0.05);
    }

    @Command(
        description = "Inserir moeda",
        abbrev = "m25",
        name = "m25")
    public void inserirMoeda25() {

        inserirMoeda(0.25);
    }

    @Command(
        description = "Inserir moeda",
        abbrev = "m10",
        name = "m10")
    public void inserirMoeda10() {

        inserirMoeda(0.10);
    }

    public void inserirMoeda(double valor, int count) {

        for (int i = 0; i < count; i++) {

            inserirMoeda(valor);
        }
    }

    public void inserirMoeda(double valor) {

        println(
            "Moeda de R$ %.2f inserida",
            valor);
    }

    public static void start() throws IOException {

        Shell shell = ShellFactory.createConsoleShell(
            "$",
            PROGRAM_NAME,
            new ConsumidorShell());

        shell.commandLoop();
    }
}
