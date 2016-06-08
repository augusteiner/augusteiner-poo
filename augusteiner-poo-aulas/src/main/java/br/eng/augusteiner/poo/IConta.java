
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public interface IConta {

    void depositar(double valor);
    void sacar(double valor);

    double getSaldo();
}
