
package br.eng.augusteiner.poo.aulas;

import br.eng.augusteiner.poo.AgendaComList;
import br.eng.augusteiner.poo.Contato;
import br.eng.augusteiner.poo.ContatoNaoEncontradoException;
import br.eng.augusteiner.poo.IAgenda;
import br.eng.augusteiner.poo.IContato;
import br.eng.augusteiner.poo.Pessoa;
import br.eng.augusteiner.poo.PessoaFisica;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_16_06_16_Exceptions_Cont {

    public static void main(String[] args) {

        Pessoa p1 = new PessoaFisica(
            "José Augusto",
            "07134269426");

        System.out.println(p1);

        String nomeContato = "José Augusto";

        IAgenda agenda = new AgendaComList();
        IContato c1 = new Contato(
            nomeContato,
            "+55 (84) 9 9999-9999");

        agenda.inserir(c1);

        try {

            IContato contato = agenda.buscar(nomeContato);

            System.out.println(String.format(
                "Contato encontrado '%s'",
                contato));

        } catch (ContatoNaoEncontradoException e) {

            System.out.println(e.getMessage());
        }
    }
}
