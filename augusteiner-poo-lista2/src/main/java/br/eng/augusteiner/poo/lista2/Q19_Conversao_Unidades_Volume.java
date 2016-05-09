
package br.eng.augusteiner.poo.lista2;

import static br.eng.augusteiner.poo.ConversaoDeUnidadesDeVolume.*;
import static br.eng.augusteiner.poo.Util.println;

public class Q19_Conversao_Unidades_Volume {

    private static final double VALOR_TESTE = 1;

    public static void main(String[] args) {

        println(
            "%s L = %s cm³",
            VALOR_TESTE,
            litrosParaCm3(VALOR_TESTE));

        println(
            "%s m³ = %s L",
            VALOR_TESTE,
            m3ParaLitro(VALOR_TESTE));

        println(
            "%s m³ = %s pés cúbicos",
            VALOR_TESTE,
            m3ParaPe3(VALOR_TESTE));

        println(
            "%s galão americano = %s polegadas³",
            VALOR_TESTE,
            galaoParaPol3(VALOR_TESTE));

        println(
            "%s galão americano = %s L",
            VALOR_TESTE,
            galaoParaLitro(VALOR_TESTE));

    }
}
