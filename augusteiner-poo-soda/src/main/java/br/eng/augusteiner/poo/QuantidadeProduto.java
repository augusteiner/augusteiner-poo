
package br.eng.augusteiner.poo;

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

    @Override
    public String toString() {

        return String.format(
            "%s (%s)",
            this.getProduto(),
            this.getQuantidade());
    }

    public void removeQuantidade(int quantidade) {

        this.addQuantidade(-quantidade);
    }
}