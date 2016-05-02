
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.ConversaoDeUnidadesDeVolume.*;
import static br.eng.augusteiner.poo.lista2.Util.sysout;

public class Q19_Conversao_Unidades_Volume {

    private static final double VALOR_TESTE = 1;

    public static void main(String[] args) {

        sysout(
            "%s L = %s cm³",
            VALOR_TESTE,
            litrosParaCm3(VALOR_TESTE));

        sysout(
            "%s m³ = %s L",
            VALOR_TESTE,
            m3ParaLitro(VALOR_TESTE));

        sysout(
            "%s m³ = %s pés cúbicos",
            VALOR_TESTE,
            m3ParaPe3(VALOR_TESTE));

        sysout(
            "%s galão americano = %s polegadas³",
            VALOR_TESTE,
            galaoParaPol3(VALOR_TESTE));

        sysout(
            "%s galão americano = %s L",
            VALOR_TESTE,
            galaoParaLitro(VALOR_TESTE));

    }
}
