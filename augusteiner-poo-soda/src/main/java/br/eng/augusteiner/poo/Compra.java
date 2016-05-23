
package br.eng.augusteiner.poo;

import static br.eng.augusteiner.poo.Moeda.*;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import br.eng.augusteiner.poo.soda.Util;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Compra {

    public static final byte STATUS_ENTRADA_INSUFICIENTE = 1;
    public static final byte STATUS_PRODUTO_NAO_SELECIONADO = 2;
    public static final byte STATUS_INDEFINIDO = 4;
    public static final byte STATUS_PRODUTO_INSUFICIENTE = 8;
    public static final byte STATUS_OK = 32;
    public static final byte STATUS_OK_FALTA_TROCO = 40;

    private Produto produto;

    private Map<Moeda, QuantidadeMoeda> entrada;
    private Map<Moeda, QuantidadeMoeda> troco;

    private Date data;
    private byte status = STATUS_INDEFINIDO;

    public Compra() {

        this.entrada = new Hashtable<Moeda, QuantidadeMoeda>();
        this.troco = new Hashtable<Moeda, QuantidadeMoeda>();

        this.status = STATUS_INDEFINIDO;

        initEntrada();
    }

    private void initEntrada() {

        initMap(this.entrada);
    }

    public void addMoeda(Moeda moeda, int quantidade) {

        QuantidadeMoeda qte = this.entrada.get(moeda);

        qte.addQuantidade(quantidade);
    }

    public Date getData() {

        return this.data;
    }

    public Iterable<QuantidadeMoeda> getEntrada() {

        return this.entrada.values();
    }

    public Produto getProduto() {

        return this.produto;
    }

    public byte getStatus() {

        return this.status;
    }

    public String getStatusAsString() {

        switch (this.getStatus()) {

            case STATUS_ENTRADA_INSUFICIENTE:
                return "Entrada para compra insuficiente";

            case STATUS_OK:
                return "Compra ok";

            case STATUS_OK_FALTA_TROCO:
                return "Compra ok com moedas para troco em falta";

            case STATUS_PRODUTO_NAO_SELECIONADO:
                return "Produto da compra não selecionado";

            case STATUS_INDEFINIDO:
                return "Compra não iniciada";

            default:
                return "Erro desconhecido";
        }
    }

    public Iterable<QuantidadeMoeda> getTroco() {

        return this.troco.values();
    }

    public double getValorEntrada() {

        return Util.moedasToDouble(getEntrada());
    }

    public double getValorTroco() {

        return Util.moedasToDouble(getTroco());
    }

    public void setData(Date data) {

        this.data = data;
    }

    public void setProduto(Produto produto) {

        this.produto = produto;
    }

    public void setStatus(byte status) {

        this.status = status;
    }

    void setTroco(Iterable<QuantidadeMoeda> troco) {

        this.troco.clear();

        for (QuantidadeMoeda qte : troco) {

            this.troco.put(
                qte.getMoeda(),
                qte);
        }
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
