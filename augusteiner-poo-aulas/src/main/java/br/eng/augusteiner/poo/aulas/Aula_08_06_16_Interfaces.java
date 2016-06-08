
package br.eng.augusteiner.poo.aulas;

import br.eng.augusteiner.poo.Conta;
import br.eng.augusteiner.poo.IConta;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_08_06_16_Interfaces {

    /**
     * @param args
     */
    public static void main(String[] args) {

        double saldo = 1500.25;
        double saque = 1.21;

        IConta conta = new Conta(saldo);

        conta.sacar(saque);
        conta.sacar(saque);
        conta.sacar(saque);
        conta.sacar(saque);

        saldo -= saque;
        saldo -= saque;
        saldo -= saque;
        saldo -= saque;

        System.out.println(conta.getSaldo());

        System.out.println(saldo);
    }
}
