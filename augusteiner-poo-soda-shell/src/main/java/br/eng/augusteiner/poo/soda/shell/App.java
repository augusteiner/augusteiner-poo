
package br.eng.augusteiner.poo.soda.shell;

import static br.eng.augusteiner.poo.Util.println;
import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.CYAN;
import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.Color.YELLOW;

import java.io.IOException;

import org.fusesource.jansi.Ansi;

import br.eng.augusteiner.poo.Maquina;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    public static final Maquina MAQUINA = Maquina.getSingleton();

    private static final boolean CONSOLE_EXISTS = System.console() != null;

    public static void main(String[] args) throws IOException {

        ConsumidorShell.iniciar();
    }

    public static void exibir(
        Ansi ansi,
        String text) {

        if (CONSOLE_EXISTS) {

            println(ansi.a(text).reset().toString());
        } else {

            println(text);
        }
    }

    public static void exibirMoedas(Object qte) {

        exibir(
            produto(),
            qte.toString());
    }

    public static void exibirProduto(Object produto) {

        exibir(
            produto(),
            produto.toString());
    }

    private static Ansi produto() {

        return ansi().fg(CYAN).bold();
    }

    public static void exibirAlerta(String mensagem) {

        exibir(
            warning(),
            mensagem);
    }

    private static Ansi warning() {

        return ansi().fg(YELLOW).bold();
    }

    public static void exibirAlerta(
        String format,
        Object... args) {

        exibirAlerta(String.format(
            format,
            args));
    }

    public static void exibirErro(
        String format,
        Object... args) {

        exibirErro(String.format(
            format,
            args));
    }

    public static void exibirErro(String mensagem) {

        exibir(
            error(),
            mensagem);
    }

    private static Ansi error() {

        return ansi().fg(RED).bold();
    }

    public static void exibirMensagem(String text) {

        exibir(
            info(),
            text);
    }

    private static Ansi info() {

        return ansi().fg(GREEN).bold();
    }

    public static void exibirMensagem(
        String format,
        Object... args) {

        exibirMensagem(String.format(
            format,
            args));
    }
}
