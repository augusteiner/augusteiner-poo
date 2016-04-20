
package br.eng.augusteiner.poo.maq;

import java.util.Date;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Compra {
    private Produto produto;

    private Moeda[] entrada;
    private Moeda[] troco;

    private Date data;

    public Compra(Produto produto, Moeda[] entrada, Moeda[] troco, Date data) {

        this.produto = produto;

        this.entrada = entrada;
        this.troco = troco;

        this.data = data;
    }

    public Produto getProduto() {

        return produto;
    }

    public void setProduto(Produto produto) {

        this.produto = produto;
    }

    public Moeda[] getEntrada() {

        return entrada;
    }

    public void setEntrada(Moeda[] entrada) {

        this.entrada = entrada;
    }

    public Moeda[] getTroco() {

        return troco;
    }

    public void setTroco(Moeda[] troco) {

        this.troco = troco;
    }

    public Date getData() {

        return data;
    }

    public void setData(Date data) {

        this.data = data;
    }

    public double getValorEntrada() {

        return Util.moedasToDouble(getEntrada());
    }

    public double getValorTroco() {

        return Util.moedasToDouble(getTroco());
    }

    @Override
    public String toString() {

        return String.format(
            "#%s: %s R$ %s - R$ %s = R$ %s",
            getData(),
            getProduto().getNome(),
            getProduto().getPreco(),
            getValorEntrada(),
            getValorTroco());
    }
}
