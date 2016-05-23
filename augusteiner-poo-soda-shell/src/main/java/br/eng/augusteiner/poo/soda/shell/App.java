
package br.eng.augusteiner.poo.soda.shell;

import static br.eng.augusteiner.poo.Util.*;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import java.io.IOException;

import org.fusesource.jansi.Ansi;

import br.eng.augusteiner.poo.Maquina;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    public static final Maquina MAQUINA = Maquina.getSingleton();

    private static final boolean CONSOLE_EXISTS = System.console() != null;

    private static Ansi error() {

        return ansi().fg(RED).bold();
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

    public static void exibirAlerta(String mensagem) {

        exibir(
            warning(),
            mensagem);
    }

    public static void exibirAlerta(
        String format,
        Object... args) {

        exibirAlerta(String.format(
            format,
            args));
    }

    public static void exibirErro(String mensagem) {

        exibir(
            error(),
            mensagem);
    }

    public static void exibirErro(
        String format,
        Object... args) {

        exibirErro(String.format(
            format,
            args));
    }

    public static void exibirMensagem(String text) {

        exibir(
            info(),
            text);
    }

    public static void exibirMensagem(
        String format,
        Object... args) {

        exibirMensagem(String.format(
            "~> " + format,
            args));
    }

    public static void exibirMoeda(Object moeda) {

        exibir(
            moeda(),
            "$$ " + moeda.toString());
    }

    private static Ansi moeda() {

        return ansi().fg(BLUE).bold();
    }

    public static void exibirProduto(Object produto) {

        exibir(
            produto(),
            produto.toString());
    }

    private static Ansi info() {

        return ansi().fg(GREEN).bold();
    }

    public static void main(String[] args) throws IOException {

        ConsumidorShell.iniciar();
    }

    private static Ansi produto() {

        return ansi().fg(CYAN).bold();
    }

    private static Ansi warning() {

        return ansi().fg(YELLOW).bold();
    }
}
