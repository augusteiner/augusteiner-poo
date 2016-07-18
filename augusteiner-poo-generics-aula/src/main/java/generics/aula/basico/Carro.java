
package generics.aula.basico;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Carro {

    public static final int COR_AZUL = 1;
    public static final int COR_AMARELA = 2;
    public static final int COR_BRANCA = 3;

    private int cor;

    public Carro() {

        this(COR_AZUL);
    }

    public Carro(int cor) {

        this.cor = cor;
    }

    public int getCor() {

        return this.cor;
    }

    public String getCorAsString() {

        switch (this.cor) {
            case COR_AZUL:
                return "Azul";
            case COR_AMARELA:
                return "Amarelo";
            case COR_BRANCA:
                return "Branco";
            default:
                throw new IllegalArgumentException("Carro de cor não conhecida");
        }
    }

    public Object getQuantidadeRodas() {

        return 4;
    }

    public void setCor(int cor) {

        this.cor = cor;
    }

    public String toString() {

        return String.format("Carro %s", this.getCorAsString());
    }
}
