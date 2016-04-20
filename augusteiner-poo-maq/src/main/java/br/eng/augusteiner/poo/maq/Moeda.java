
package br.eng.augusteiner.poo.maq;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Moeda {

    private double valor;
    private String descricao;

    public Moeda() {

    }

    public Moeda(double valor, String descricao) {

        this.valor = valor;
        this.descricao = descricao;
    }

    public double getValor() {

        return valor;
    }

    public void setValor(double valor) {

        this.valor = valor;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    @Override
    public String toString() {

        return String.format(
            "R$ %.2f (%s)",
            getValor(),
            getDescricao());
    }
}
