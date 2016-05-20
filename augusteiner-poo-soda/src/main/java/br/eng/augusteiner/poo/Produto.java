
package br.eng.augusteiner.poo;

import static br.eng.augusteiner.poo.Moeda.LOCALE_PADRAO;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Produto {

    private String codigo;

    private String descricao;

    private double preco;

    public Produto() {

    }

    public Produto(
        String codigo,
        String descricao,
        double preco) {

        this.codigo = codigo;

        this.descricao = descricao;

        this.preco = preco;
    }

    public String getCodigo() {

        return codigo;
    }

    public void setCodigo(String codigo) {

        this.codigo = codigo;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public double getPreco() {

        return preco;
    }

    public void setPreco(double preco) {

        this.preco = preco;
    }

    @Override
    public String toString() {

        return String.format(
            LOCALE_PADRAO,
            "#%s - %s : R$ %.2f",
            getCodigo(),
            getDescricao(),
            getPreco());
    }
}
