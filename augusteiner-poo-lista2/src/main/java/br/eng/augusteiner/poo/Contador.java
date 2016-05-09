
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Contador {

    private static final int PASSO_PADRAO = 1;

    private int i;

    public Contador() {

        this(0);
    }

    public Contador(int i) {

        setI(i);
    }

    public int getI() {

        return this.i;
    }

    public void setI(int i) {

        if (i >= 0) {

            this.i = i;
        } else {

            this.i = 0;
        }
    }

    /**
     * Pós-incremento
     *
     * @param f
     * @return
     */
    public int incrementar(boolean f) {

        return incrementar(
            PASSO_PADRAO,
            f);
    }

    /**
     * Pós-decremento
     *
     * @param f
     * @return
     */
    public int decrementar(boolean f) {

        return decrementar(
            PASSO_PADRAO,
            f);
    }

    /**
     * Pré-incremento
     *
     * @param n
     * @return
     */
    public int incrementar() {

        return incrementar(PASSO_PADRAO);
    }

    /**
     * Pré-decremento
     *
     * @param n
     * @return
     */
    public int decrementar() {

        return decrementar(PASSO_PADRAO);
    }

    /**
     * Pós-incremento
     *
     * @param n
     * @return
     */
    public int incrementar(
        int n,
        boolean f) {

        try {

            return getI();
        } finally {

            incrementar(n);
        }
    }

    /**
     * Pós-decremento
     *
     * @param n
     * @return
     */
    public int decrementar(
        int n,
        boolean f) {

        try {

            return getI();
        } finally {

            decrementar(n);
        }
    }

    /**
     * Pré-incremento
     *
     * @param n
     * @return
     */
    public int incrementar(int n) {

        setI(getI() + n);

        return getI();
    }

    /**
     * Pré-decremento
     *
     * @param n
     * @return
     */
    public int decrementar(int n) {

        setI(getI() - n);

        return getI();
    }

    public static Contador novo() {

        return new Contador();
    }

    @Override
    public String toString() {

        return String.format(
            "%d",
            getI());
    }
}
