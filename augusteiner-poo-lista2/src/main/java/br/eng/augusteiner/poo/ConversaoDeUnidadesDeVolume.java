
package br.eng.augusteiner.poo;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class ConversaoDeUnidadesDeVolume {

    private static final double FATOR_CONV_LITRO_C3 = 1000;
    private static final double FATOR_CONV_M3_LITRO = 1000;
    private static final double FATOR_CONV_M3_PE3 = 35.32;
    private static final double FATOR_CONV_GALAO_POL3 = 231;
    private static final double FATOR_CONV_GALAO_LITRO = 3.785;

    public static double galaoParaLitro(double galoes) {

        return galoes * FATOR_CONV_GALAO_LITRO;
    }

    public static double galaoParaPol3(double galoes) {

        return galoes * FATOR_CONV_GALAO_POL3;
    }

    public static double litrosParaCm3(double litros) {

        return litros * FATOR_CONV_LITRO_C3;
    }

    public static double m3ParaLitro(double metros3) {

        return metros3 * FATOR_CONV_M3_LITRO;
    }

    public static double m3ParaPe3(double m3) {

        return m3 * FATOR_CONV_M3_PE3;
    }
}
