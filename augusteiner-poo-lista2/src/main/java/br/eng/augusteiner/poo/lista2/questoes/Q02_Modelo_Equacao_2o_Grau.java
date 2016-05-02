
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.Util.sysout;

import br.eng.augusteiner.poo.lista2.classes.EquacaoSegundoGrau;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q02_Modelo_Equacao_2o_Grau {

    /**
     * @param args
     */
    public static void main(String[] args) {

        EquacaoSegundoGrau equacao1 = new EquacaoSegundoGrau(
            1,
            -6,
            -27);
        double raizes[] = equacao1.raizes();

        sysout(
            "Equação: %s ~> (x': %s, x'': %s)",
            equacao1,
            raizes[0],
            raizes[1]);
    }
}
