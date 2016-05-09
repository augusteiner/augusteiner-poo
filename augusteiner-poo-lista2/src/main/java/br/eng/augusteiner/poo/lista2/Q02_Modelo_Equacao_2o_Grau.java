
package br.eng.augusteiner.poo.lista2;

import static br.eng.augusteiner.poo.Util.println;

import br.eng.augusteiner.poo.EquacaoSegundoGrau;

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

        println(
            "Equação: %s ~> (x': %s, x'': %s)",
            equacao1,
            raizes[0],
            raizes[1]);
    }
}
