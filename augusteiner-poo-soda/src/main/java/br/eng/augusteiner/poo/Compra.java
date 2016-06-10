
package br.eng.augusteiner.poo;

import static br.eng.augusteiner.poo.soda.Util.*;
import static br.eng.augusteiner.poo.Moeda.*;

import java.text.DateFormat;
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

    public static final DateFormat FORMATO_DATA_PADRAO = DateFormat.getDateTimeInstance(
        DateFormat.SHORT,
        DateFormat.SHORT,
        LOCALE_PADRAO);

    private static String statusAsString(byte status) {

        switch (status) {

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
                return "Status desconhecido";
        }
    }

    public static String statusAsString(Compra compra) {

        return statusAsString(compra.getStatus());
    }

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

    public void addMoeda(
        Moeda moeda,
        int quantidade) {

        QuantidadeMoeda qte = this.entrada.get(moeda);

        qte.addQuantidade(quantidade);
    }

    public Date getData() {

        return this.data;
    }

    public String getDataAsString() {

        return this.getFormatoData().format(this.getData());
    }

    public Iterable<QuantidadeMoeda> getEntrada() {

        return this.entrada.values();
    }

    protected DateFormat getFormatoData() {

        return FORMATO_DATA_PADRAO;
    }

    public Produto getProduto() {

        return this.produto;
    }

    public byte getStatus() {

        return this.status;
    }

    public String getStatusAsString() {

        return statusAsString(this.getStatus());
    }

    public Iterable<QuantidadeMoeda> getTroco() {

        return this.troco.values();
    }

    public double getValorEntrada() {

        return Util.moedasToDouble(this.getEntrada());
    }

    public double getValorTroco() {

        return Util.moedasToDouble(this.getTroco());
    }

    private void initEntrada() {

        initMap(this.entrada);
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

            this.getDataAsString(),

            this.getProduto().getDescricao(),

            SIMBOLO,
            this.getProduto().getPreco(),

            SIMBOLO,
            this.getValorEntrada(),

            SIMBOLO,
            this.getValorTroco());
    }
}
