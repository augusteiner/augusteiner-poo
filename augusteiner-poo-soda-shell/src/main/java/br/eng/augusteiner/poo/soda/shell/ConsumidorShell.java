
package br.eng.augusteiner.poo.soda.shell;

import static br.eng.augusteiner.poo.Util.println;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import java.io.IOException;

import org.fusesource.jansi.Ansi;

import com.budhash.cliche.Command;
import com.budhash.cliche.Param;
import com.budhash.cliche.Shell;
import com.budhash.cliche.ShellFactory;

import br.eng.augusteiner.poo.Produto;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ConsumidorShell {

    public static final String PROGRAM_NAME = ConsumidorShell.class.getSimpleName();

    private static final boolean CONSOLE_EXISTS = System.console() != null;

    private static final Ansi WARNING = ansi().fg(YELLOW).bold();
    private static final Ansi ERROR = ansi().fg(RED).bold();
    private static final Ansi INFO = ansi().fg(GREEN).bold();

    public static void start() throws IOException {

        Shell shell = ShellFactory.createConsoleShell(
            "$",
            PROGRAM_NAME,
            new ConsumidorShell());

        shell.commandLoop();
    }

    @Command(
        description = "Iniciar console de adm. da máquina de refris",
        abbrev = "admin",
        name = "admin")
    public void admin() throws IOException {

        AdminShell.start();
    }

    private Produto buscarRefrigerante(String codigo) {

        return null;
    }

    private void exibir(
        Ansi ansi,
        String text) {

        if (CONSOLE_EXISTS) {

            println(ansi.a(text).reset().toString());
        } else {

            println(text);
        }
    }

    private void exibirAlerta(String mensagem) {

        exibir(
            WARNING,
            mensagem);
    }

    private void exibirAlerta(
        String format,
        Object... args) {

        exibirAlerta(String.format(
            format,
            args));
    }

    private void exibirErro(String mensagem) {

        exibir(
            ERROR,
            mensagem);
    }

    private void exibirMensagem(String text) {

        exibir(
            INFO,
            text);
    }

    private void exibirMensagem(
        String format,
        Object... args) {

        exibirMensagem(String.format(
            format,
            args));
    }

    public void inserirMoeda(double valor) {

        exibirMensagem(
            "Moeda de R$ %.2f inserida",
            valor);
    }

    public void inserirMoeda(double valor, int qte) {

        for (int i = 0; i < qte; i++) {

            inserirMoeda(valor);
        }
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m1",
        name = "m1")
    public void inserirMoeda1() {

        inserirMoeda(1);
    }

    @Command(
        description = "Inserir moeda de R$ 0,10",
        abbrev = "m10",
        name = "m10")
    public void inserirMoeda10() {

        inserirMoeda(0.10);
    }

    @Command(
        description = "Inserir moeda de R$ 0,25",
        abbrev = "m25",
        name = "m25")
    public void inserirMoeda25() {

        inserirMoeda(0.25);
    }

    @Command(
        description = "Inserir moeda de R$ 0,05",
        abbrev = "m5",
        name = "m5")
    public void inserirMoeda5() {

        inserirMoeda(0.05);
    }

    @Command(
        description = "Inserir moeda de R$ 0,05",
        abbrev = "m5",
        name = "m5")
    public void inserirMoeda5(
        @Param(name = "qte", description = "Qte de moedas de R$ 0.05 a inserir")
        int count) {

        inserirMoeda(0.05, count);
    }

    @Command(
        description = "Inserir moeda de R$ 0,50",
        abbrev = "m50",
        name = "m50")
    public void inserirMoeda50() {

        inserirMoeda(0.50);
    }

    @Command(
        description = "Retirada de refrigerante(s)")
    public void retirada() {

        //
    }

    @Command(
        description = "Seleção de refrigerante")
    public void selecionar(
        @Param(name = "Código", description = "Código do refrigerante")
        String codigo) {

        selecionar(codigo, 1);
    }

    @Command(
        description = "Seleção de refrigerante")
    public void selecionar(
        @Param(name = "Código", description = "Código do refrigerante")
        String codigo,
        @Param(name = "Qte", description = "Quantidade de refrigerantes")
        int qte) {

        Produto refri = buscarRefrigerante(codigo);

        if (refri != null) {

            //
        } else {

            exibirAlerta(
                "Refrigerante #%s não encontrado!",
                codigo);
        }
    }
}
