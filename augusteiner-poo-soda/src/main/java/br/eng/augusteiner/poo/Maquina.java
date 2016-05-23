
package br.eng.augusteiner.poo;

import static java.lang.Math.*;

import java.math.BigDecimal;

import static br.eng.augusteiner.poo.Compra.*;
import static br.eng.augusteiner.poo.Moeda.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    private void removeMoeda(
        Moeda moeda,
        int quantidade) {

        //System.out.println(String.format(
        //    "Removendo moeda %s (%d)",
        //    moeda,
        //    quantidade));

        addMoeda(
            moeda,
            - quantidade);
    }

    public void addMoeda(Moeda moeda) {

        this.addMoeda(
            moeda,
            1);
    }

    private void addMoeda(
        Moeda moeda,
        int quantidade) {

        QuantidadeMoeda qte = this.moedas.get(moeda);

        qte.addQuantidade(quantidade);
    }

    public void inserirMoeda(Moeda moeda) {

        this.addMoeda(moeda);

        this.getCompraAtual().addMoeda(
            moeda,
            1);
    }

    public void addProduto(Produto produto) {

        this.addProduto(
            produto,
            0);
    }

    public void addProduto(
        Produto produto,
        int quantidade) {

        QuantidadeProduto qte = this.estoque.get(produto);

        if (qte == null) {

            qte = new QuantidadeProduto(
                produto,
                0);

            this.estoque.put(
                produto,
                qte);
        }

        qte.addQuantidade(quantidade);
    }

    public Iterable<QuantidadeProduto> getEstoque() {

        return this.estoque.values();
    }

    public Iterable<QuantidadeMoeda> getMoedas() {

        return this.moedas.values();
    }

    public Iterable<Produto> getProdutosAVenda() {

        return this.estoque.keySet()
            .stream()
            .filter(new Predicate<Produto>() {

                @Override
                public boolean test(Produto t) {

                    QuantidadeProduto qte = Maquina.this.estoque.get(t);

                    return qte != null &&
                        qte.getQuantidade() > 0;
                }})
            .collect(Collectors.toList());
    }

    public Iterable<Produto> getProdutos() {

        return this.estoque.keySet();
    }

    private void initMoedas() {

        initMap(this.moedas);
    }

    public Produto produto(String codigo) {

        for (Produto produto : this.getProdutos()) {

            if (produto.getCodigo().equals(codigo)) {

                return produto;
            }
        }

        return null;
    }

    public void novaCompra() {

        if (this.compraAtual == null) {

            this.compraAtual = new Compra();
        }
    }

    public Compra getCompraAtual() {

        return this.compraAtual;
    }

    private void setCompraAtual(Compra compraAtual) {

        this.compraAtual = compraAtual;
    }

    public Compra encerrarCompra() {

        Compra compra = this.getCompraAtual();
        Produto produto;
        QuantidadeProduto qte;

        if (compra == null) {

            return compra;
        }

        produto = compra.getProduto();

        if (produto == null) {

            compra.setStatus(STATUS_PRODUTO_NAO_SELECIONADO);

        } else if (compra.getValorEntrada() < produto.getPreco()) {

            compra.setStatus(STATUS_ENTRADA_INSUFICIENTE);

        } else {
            qte = this.estoque.get(produto);

            if (qte == null ||
                qte.getQuantidade() == 0) {

                compra.setStatus(STATUS_PRODUTO_INSUFICIENTE);

            } else {

                compra.setStatus(STATUS_OK);

            }
        }

        if (compra.getStatus() == STATUS_OK) {

            this.setCompraAtual(null);

            this.calcularTroco(compra);

            for (QuantidadeMoeda qteTroco : compra.getTroco()) {

                removeMoeda(
                    qteTroco.getMoeda(),
                    qteTroco.getQuantidade());
            }

            this.removerProduto(produto);

            if (produto.getPreco() != compra.getValorTroco()) {

                compra.setStatus(STATUS_OK_FALTA_TROCO);
            }
        }

        return compra;
    }

    private void removerProduto(Produto produto) {

        this.estoque.get(produto).removeQuantidade(1);
    }

    private void calcularTroco(Compra compra) {

        calcularTroco(
            this,
            compra);
    }

    private static void calcularTroco(
        Maquina maquina,
        Compra compra) {

        Produto produto = compra.getProduto();
        List<QuantidadeMoeda> troco = new ArrayList<QuantidadeMoeda>();

        BigDecimal valorTroco = BigDecimal.valueOf(compra.getValorEntrada())
            .subtract(BigDecimal.valueOf(produto.getPreco()));

        //System.out.println(String.format(
        //    "Troco a dar: %s",
        //    valorTroco));

        for (Moeda moeda : Moeda.getMoedasConhecidas()) {

            int qte = valorTroco.multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(moeda.getValor())
                    .multiply(BigDecimal.valueOf(100)))
                .intValue();

            qte = min(
                qte,
                maquina.getQuantidadeMoedas(moeda));

            //System.out.println(String.format(
            //    "%s * 100 / %s * 100 = %s",
            //    valorTroco,
            //    moeda.getValor(),
            //    qte));

            troco.add(new QuantidadeMoeda(
                moeda,
                qte));

            valorTroco = valorTroco.subtract(
                BigDecimal.valueOf(moeda.getValor()).multiply(BigDecimal.valueOf(qte)));
        }

        //System.out.println("Troco calculado:");
        //
        //for (QuantidadeMoeda qte : troco) {
        //
        //    System.out.println(String.format(
        //        "%s",
        //        qte));
        //}

        compra.setTroco(troco);
    }

    public int getQuantidadeMoedas(Moeda moeda) {

        QuantidadeMoeda qte = this.moedas.get(moeda);

        return qte != null ? qte.getQuantidade() : 0;
    }
}
