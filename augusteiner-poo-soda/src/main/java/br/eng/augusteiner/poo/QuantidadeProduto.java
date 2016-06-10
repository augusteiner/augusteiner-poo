
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
class QuantidadeProduto implements IQuantidadeProduto {

    private Produto produto;
    private int quantidade;

    public QuantidadeProduto(Produto produto, int quantidade) {

        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void addQuantidade(int quantidade) {

        this.quantidade += quantidade;
    }

    @Override
    public Produto getProduto() {

        return this.produto;
    }

    @Override
    public int getQuantidade() {

        return this.quantidade;
    }

    public void removeQuantidade(int quantidade) {

        this.addQuantidade(-quantidade);
    }

    @Override
    public String toString() {

        return String.format(
            "%s (%s)",
            this.getProduto(),
            this.getQuantidade());
    }
}
