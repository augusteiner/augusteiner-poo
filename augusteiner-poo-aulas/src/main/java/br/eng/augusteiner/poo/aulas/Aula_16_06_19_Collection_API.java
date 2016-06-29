
package br.eng.augusteiner.poo.aulas;

import br.eng.augusteiner.poo.AgendaComList;
import br.eng.augusteiner.poo.AgendaComMapImpl;
import br.eng.augusteiner.poo.Contato;
import br.eng.augusteiner.poo.ContatoNaoEncontradoException;
import br.eng.augusteiner.poo.IAgenda;
import br.eng.augusteiner.poo.IContato;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_16_06_19_Collection_API {

    private static void exibirContatos(IAgenda agenda) {

        System.out.println("--------------------");
        System.out.println(String.format(
            "Contatos na agenda {%s}",
            agenda.getClass().getSimpleName()));
        System.out.println("--------------------");

        for (IContato contato : agenda.getContatos()) {

            System.out.println(contato);
        }
    }

    public static void main(String[] args) {

        IAgenda a1 = new AgendaComList();
        IAgenda a2 = new AgendaComMapImpl();

        String nome = "José Augusto";

        IContato c1 = new Contato(nome, "+ 55 (84) 9 9999-9999");

        a1.inserir(c1);
        a2.inserir(c1);

        try {

            System.out.println(a1.buscar(c1.getNome()));
            System.out.println(a2.buscar(c1.getNome()));

            System.out.println(a1.quantidadeContatos());
            System.out.println(a2.quantidadeContatos());

            exibirContatos(a1);
            exibirContatos(a2);

            a1.remover(c1.getNome());
            a2.remover(c1.getNome());

            System.out.println(a1.quantidadeContatos());
            System.out.println(a2.quantidadeContatos());

        } catch (ContatoNaoEncontradoException e) {

            e.printStackTrace();
        }
    }
}
