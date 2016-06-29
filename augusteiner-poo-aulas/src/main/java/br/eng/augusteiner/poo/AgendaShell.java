
package br.eng.augusteiner.poo;

import static br.eng.augusteiner.poo.Util.*;

import java.io.IOException;
import java.util.Scanner;

import com.budhash.cliche.Command;
import com.budhash.cliche.Shell;
import com.budhash.cliche.ShellFactory;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class AgendaShell {

    public static final String PROGRAM_NAME = "Agenda";
    public static final Scanner SCAN = new Scanner(System.in);

    public static void iniciar(IAgenda agenda) throws IOException {

        Shell shell = ShellFactory.createConsoleShell(
            "$",
            PROGRAM_NAME,
            new AgendaShell(agenda));

        shell.commandLoop();
    }

    private IAgenda agenda;

    public AgendaShell(IAgenda agenda) {

        this.agenda = agenda;
    }

    public void exibirContato(IContato contato) {

        print("Dados do contato: ");
        println(contato);
    }

    @Command()
    public void buscarTodos() {

        String nome;

        print("Informe o nome para busca: ");
        nome = lerString();

        try {

            Iterable<IContato> contatos = this.agenda.buscarTodos(nome);

            for (IContato contato : contatos) {

                exibirContato(contato);
            }

        } catch (ContatoNaoEncontradoException e) {

            println("Contato não existe!");
        }
    }

    @Command()
    public void buscar() {

        String nome;

        print("Informe o nome do contato: ");
        nome = lerString();

        try {

            IContato contato = this.agenda.buscar(nome);

            exibirContato(contato);

        } catch (ContatoNaoEncontradoException e) {

            println("Contato não existe!");
        }
    }

    @Command()
    public void listar() {

        if (this.agenda.quantidadeContatos() > 0) {

            for (IContato contato : this.agenda.getContatos()) {

                println(contato);
            }
        } else {

            println("Nenhum contato a exibir!");
        }
    }

    @Command()
    public void remover() {

        String nome;

        print("Informe o nome do contato: ");
        nome = lerString();

        try {

            this.agenda.remover(nome);

            println("Contato removido com sucesso!");

        } catch (ContatoNaoEncontradoException e) {

            println("Contato não existe!");
        }
    }

    @Command()
    public void inserir() {

        IContato contato;

        String nome;
        String fone;

        print("Informe o nome do contato: ");
        nome = lerString();

        print("Informe o telefone do contato: ");
        fone = lerString();

        contato = new Contato(
            nome,
            fone);

        this.agenda.inserir(contato);

        println("Contato inserido com sucesso!");
    }
}
