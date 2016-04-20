
package br.eng.augusteiner.poo.maq;

import java.util.Date;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Compra {
    private Produto produto;

    private Moeda[] entrada;
    private Moeda[] troco;

    private Date date;

    public Compra(Produto produto, Moeda[] entrada, Moeda[] troco, Date date) {

        this.produto = produto;

        this.entrada = entrada;
        this.troco = troco;

        this.date = date;
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

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
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
            "%s R$ %s - R$ %s = R$ %s",
            getProduto().getNome(),
            getProduto().getPreco(),
            getValorEntrada(),
            getValorTroco());
    }
}
