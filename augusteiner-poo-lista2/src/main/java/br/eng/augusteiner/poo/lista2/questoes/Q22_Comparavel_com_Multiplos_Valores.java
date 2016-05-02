
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.Util.sysout;

import br.eng.augusteiner.poo.lista2.Comparavel;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q22_Comparavel_com_Multiplos_Valores {

    public static final double VALOR_TESTE = 5.0;

    public static void main(String[] args) {

        double v1 = VALOR_TESTE + 1;
        double v2 = VALOR_TESTE + 2;
        double v3 = VALOR_TESTE + 3;
        double v4 = VALOR_TESTE + 4;
        double v5 = VALOR_TESTE + 5;

        Comparavel cp1 = new Comparavel(VALOR_TESTE);

        sysout(
            "%.2f == (%.2f || %.2f || %.2f || %.2f || %.2f) == (%s)",
            cp1.getValor(),
            v1,
            v2,
            v3,
            v4,
            v5,
            cp1.eIgualAQualquerUmDe(
                v1,
                v2,
                v3,
                v4,
                v5));
    }
}
