
package br.eng.augusteiner.poo.soda;

import br.eng.augusteiner.poo.Produto;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class QuantidadeProduto {

    private Produto produto;
    private int quantidade;

    public QuantidadeProduto(Produto produto, int quantidade) {

        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {

        return this.produto;
    }

    public void setProduto(Produto produto) {

        this.produto = produto;
    }

    public int getQuantidade() {

        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {

        this.quantidade = quantidade;
    }

    public void addQuantidade(int quantidade) {

        this.quantidade += quantidade;
    }
}
