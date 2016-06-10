
package br.eng.augusteiner.poo;

import static java.lang.Math.*;

import java.math.BigDecimal;
import java.time.Instant;

import static br.eng.augusteiner.poo.Compra.*;
import static br.eng.augusteiner.poo.Moeda.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public final class Maquina implements ICofrinho {

    private static class Nested {

        private static final Maquina MAQUINA = new Maquina();

        public static Maquina getSingleton() {

            return Nested.MAQUINA;
        }
    }

    /**
     * Dispensar o máximo de moedas possível ao dar troco
     */
    public static final byte TROCO_MAXIMO_MOEDAS = 1;
    /**
     * Dispensar o mínimo de moedas possível ao dar troco
     */
    public static final byte TROCO_MINIMO_MOEDAS = 2;

    /**
     * Dispensa padrão de troco
     */
    public static final byte TROCO_PADRAO = TROCO_MINIMO_MOEDAS;

    private static Iterable<QuantidadeMoeda> calcularTroco(
        BigDecimal valorTroco,
        Iterable<Moeda> moedasParaTroco,
        ICofrinho cofrinho) {

        List<QuantidadeMoeda> troco = new ArrayList<QuantidadeMoeda>();

        //System.out.println(String.format(
        //    "Troco a dar: %s",
        //    valorTroco));

        for (Moeda moeda : moedasParaTroco) {

            BigDecimal valorMoeda = BigDecimal.valueOf(moeda.getValor());

            int qte = valorTroco.divide(valorMoeda).intValue();

            qte = min(qte, cofrinho.getQuantidadeMoedas(moeda));

            //System.out.println(String.format(
            //    "%s * 100 / %s * 100 = %s",
            //    valorTroco,
            //    moeda.getValor(),
            //    qte));

            troco.add(new QuantidadeMoeda(moeda, qte));

            valorTroco = valorTroco.subtract(
                valorMoeda.multiply(BigDecimal.valueOf(qte)));
        }

        //System.out.println("Troco calculado:");
        //
        //for (QuantidadeMoeda qte : troco) {
        //
        //    System.out.println(String.format(
        //        "%s",
        //        qte));
        //}

        // compra.setTroco(troco);
        return troco;
    }

    public static Maquina getSingleton() {

        return Nested.getSingleton();
    }

    private static BigDecimal valorTroco(Compra compra) {

        Produto produto = compra.getProduto();

        BigDecimal valorProduto = BigDecimal.valueOf(produto.getPreco());
        BigDecimal valorEntrada = BigDecimal.valueOf(compra.getValorEntrada());

        return valorEntrada.subtract(valorProduto);
    }

    private Compra compraAtual;

    private Map<Moeda, QuantidadeMoeda> moedas;

    private Map<Produto, QuantidadeProduto> estoque;

    private Collection<Compra> compras;

    private Maquina() {

        moedas = new Hashtable<Moeda, QuantidadeMoeda>();
        estoque = new Hashtable<Produto, QuantidadeProduto>();
        compras = new ArrayList<Compra>();

        initMoedas();
    }

    private void addCompra(Compra compra) {

        this.compras.add(compra);
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

    private Iterable<QuantidadeMoeda> calcularTrocoMaximoMoedas(Compra compra) {

        Iterable<QuantidadeMoeda> troco = calcularTrocoMinimoMoedas(compra);

        // TODO Manipular troco mínimo para calcular troco com máximo de moedas

        return troco;
    }

    private Iterable<QuantidadeMoeda> calcularTrocoMinimoMoedas(Compra compra) {

        return calcularTroco(
            valorTroco(compra),
            Moeda.getMoedasSuportadas(),
            this);
    }

    public Compra encerrarCompra() {

        return this.encerrarCompra(TROCO_PADRAO);
    }

    public Compra encerrarCompra(byte estrategiaTroco) {

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

            Iterable<QuantidadeMoeda> troco = null;

            switch (estrategiaTroco)
            {
                case TROCO_MINIMO_MOEDAS:
                    troco = this.calcularTrocoMinimoMoedas(compra);
                    break;
                case TROCO_MAXIMO_MOEDAS:
                default:
                    troco = this.calcularTrocoMaximoMoedas(compra);
            }

            this.removerProduto(produto);

            compra.setTroco(troco);
            compra.setData(Date.from(Instant.now()));

            this.addCompra(compra);

            if (produto.getPreco() != compra.getValorTroco()) {

                compra.setStatus(STATUS_OK_FALTA_TROCO);
            }

            this.setCompraAtual(null);

            for (QuantidadeMoeda qteTroco : troco) {

                removeMoeda(
                    qteTroco.getMoeda(),
                    qteTroco.getQuantidade());
            }
        }

        return compra;
    }

    public Compra getCompraAtual() {

        return this.compraAtual;
    }

    public Iterable<Compra> getCompras() {

        return this.compras;
    }

    public Iterable<QuantidadeProduto> getEstoque() {

        return this.estoque.values();
    }

    public Iterable<? extends IQuantidadeMoeda> getMoedas() {

        return this.moedas.values();
    }

    public Iterable<Produto> getProdutos() {

        return this.estoque.keySet();
    }

    public int getQuantidadeCompras() {

        return this.compras.size();
    }

    @Override
    public int getQuantidadeMoedas(Moeda moeda) {

        QuantidadeMoeda qte = this.moedas.get(moeda);

        return qte != null ? qte.getQuantidade() : 0;
    }

    private void initMoedas() {

        initMap(this.moedas);
    }

    public void inserirMoeda(Moeda moeda) {

        this.addMoeda(moeda);

        this.getCompraAtual().addMoeda(
            moeda,
            1);
    }

    public void novaCompra() {

        if (this.compraAtual == null) {

            this.compraAtual = new Compra();
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

    public Produto produtoDisponivel(String codigo) {

        Produto produto = this.produto(codigo);

        if (produto == null ||
            this.quantidadeEstoque(produto) == 0) {

            return null;

        } else {

            return produto;

        }
    }

    public Iterable<Produto> produtosDisponiveis() {

        List<Produto> produtos = new ArrayList<Produto>();

        for (QuantidadeProduto qte : this.estoque.values()) {

            if (qte.getQuantidade() > 0) {

                produtos.add(qte.getProduto());
            }
        }

        return produtos;
    }

    public int quantidadeEstoque(Produto produto) {

        QuantidadeProduto qte = this.estoque.get(produto);

        return qte != null ? qte.getQuantidade() : 0;
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

    private void removerProduto(Produto produto) {

        this.estoque.get(produto).removeQuantidade(1);
    }

    private void setCompraAtual(Compra compraAtual) {

        this.compraAtual = compraAtual;
    }
}
