
package br.eng.augusteiner.poo;

import java.math.BigDecimal;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Conta implements IConta {

    private BigDecimal saldo;

    public Conta() {

        this(0);
    }

    public Conta(double saldo) {

        this.saldo = BigDecimal.valueOf(saldo);
    }

    @Override
    public void depositar(double valor) {

        this.saldo = this.saldo.add(BigDecimal.valueOf(valor));
    }

    @Override
    public void sacar(double valor) {

        this.saldo = this.saldo.subtract(BigDecimal.valueOf(valor));
    }

    @Override
    public double getSaldo() {

        return this.saldo.doubleValue();
    }
}
