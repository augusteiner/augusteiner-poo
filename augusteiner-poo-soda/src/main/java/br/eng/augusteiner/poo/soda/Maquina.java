
package br.eng.augusteiner.poo.soda;

import java.util.Hashtable;
import java.util.Map;

import br.eng.augusteiner.poo.Compra;
import br.eng.augusteiner.poo.Moeda;
import br.eng.augusteiner.poo.Produto;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public final class Maquina {

    private static class Nested
    {
        private static final Maquina MAQUINA = new Maquina();
    }

    public static Maquina getSingleton() {

        return Nested.MAQUINA;
    }

    private Compra compraAtual;

    private Map<Moeda, QuantidadeMoeda> moedas;

    private Map<Produto, QuantidadeProduto> estoque;

    private Maquina() {

        moedas = new Hashtable<Moeda, QuantidadeMoeda>();
        estoque = new Hashtable<Produto, QuantidadeProduto>();

        initMoedas();
    }

    public void addMoeda(Moeda moeda) {

        this.addMoeda(moeda, 1);
    }

    public void addMoeda(Moeda moeda, int quantidade) {

        this.moedas.get(moeda).addQuantidade(quantidade);
    }

    public void addProduto(Produto produto) {

        this.addProduto(produto, 1);
    }

    public void addProduto(Produto produto, int quantidade) {

        QuantidadeProduto qte = this.estoque.get(produto);

        if (qte == null) {

            qte = new QuantidadeProduto(produto, 0);

            this.estoque.put(produto, qte);
        }

        qte.addQuantidade(quantidade);
    }

    public Iterable<QuantidadeProduto> getEstoque() {

        return this.estoque.values();
    }

    public Iterable<QuantidadeMoeda> getMoedas() {

        return this.moedas.values();
    }

    public Iterable<Produto> getProdutos() {

        return this.estoque.keySet();
    }

    private void initMoedas() {

        for (Moeda moeda : Moeda.moedasConhecidas()) {

            moedas.put(moeda, new QuantidadeMoeda(moeda, 0));
        }
    }

    public Produto produto(String codigo) {

        for (Produto produto : this.getProdutos()) {

            if (produto.getCodigo().equals(codigo)) {

                return produto;
            }
        }

        return null;
    }

    public Compra getCompraAtual() {

        return this.compraAtual;
    }

    public int encerrarCompra() {

        return Compra.COMPRA_OK;
    }
}
