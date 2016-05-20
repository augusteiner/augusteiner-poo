
package br.eng.augusteiner.poo;

import static br.eng.augusteiner.poo.Moeda.LOCALE_PADRAO;
import static br.eng.augusteiner.poo.Moeda.SIMBOLO;

import java.util.Date;

import br.eng.augusteiner.poo.soda.Util;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Compra {

    public static final byte COMPRA_OK = 0;
    public static final byte COMPRA_FALTA_MOEDAS = 1;

    private Produto produto;

    private Moeda[] entrada;
    private Moeda[] troco;

    private Date data;

    public Compra(
        Produto produto,
        Moeda[] entrada,
        Moeda[] troco,
        Date data) {

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
            LOCALE_PADRAO,
            "#%s: %s %s %.2f - %s %.2f = %s %.2f",
            getData(),
            getProduto().getDescricao(),
            SIMBOLO,
            getProduto().getPreco(),
            SIMBOLO,
            getValorEntrada(),
            SIMBOLO,
            getValorTroco());
    }
}
