
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
interface IMoedeiro {

    void addMoeda(Moeda moeda);

    void addMoeda(Moeda moeda, int quantidade);

    Iterable<? extends IQuantidadeMoeda> getMoedas();

    int quantidadeMoedas(Moeda moeda);

    void removeMoeda(Moeda moeda);

    void removeMoeda(Moeda moeda, int quantidade);
}
