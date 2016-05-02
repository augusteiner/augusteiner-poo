
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.ConversaoDeTemperatura.*;
import static br.eng.augusteiner.poo.lista2.Util.sysout;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q20_Conversao_Temperatura {

    public static final double VALOR_TESTE = 1;

    public static void main(String[] args) {

        printConversoesDeCelsius();
        sysout("-----------");

        printConversoesDeFahrenheit();
        sysout("-----------");

        printConversoesDeKelvin();
        sysout("-----------");

        printConversoesDeRankine();
        sysout("-----------");

        printConversoesDeReaumur();
    }

    private static void printConversoesDeCelsius() {

        sysout(
            "%.3f C = %.3f F",
            VALOR_TESTE,
            celsiusParaFahrenheit(VALOR_TESTE));
        sysout(
            "%.3f C = %.3f K",
            VALOR_TESTE,
            celsiusParaKelvin(VALOR_TESTE));
        sysout(
            "%.3f C = %.3f R",
            VALOR_TESTE,
            celsiusParaRankine(VALOR_TESTE));
        sysout(
            "%.3f C = %.3f Re",
            VALOR_TESTE,
            celsiusParaReaumur(VALOR_TESTE));
    }

    private static void printConversoesDeFahrenheit() {

        sysout(
            "%.3f F = %.3f C",
            VALOR_TESTE,
            fahrenheitParaCelsius(VALOR_TESTE));
        sysout(
            "%.3f F = %.3f K",
            VALOR_TESTE,
            fahrenheitParaKelvin(VALOR_TESTE));
        sysout(
            "%.3f F = %.3f R",
            VALOR_TESTE,
            fahrenheitParaRankine(VALOR_TESTE));
        sysout(
            "%.3f F = %.3f Re",
            VALOR_TESTE,
            fahrenheitParaReaumur(VALOR_TESTE));
    }

    private static void printConversoesDeKelvin() {

        sysout(
            "%.3f K = %.3f C",
            VALOR_TESTE,
            kelvinParaCelsius(VALOR_TESTE));
        sysout(
            "%.3f K = %.3f F",
            VALOR_TESTE,
            kelvinParaFahrenheit(VALOR_TESTE));
        sysout(
            "%.3f K = %.3f R",
            VALOR_TESTE,
            kelvinParaRankine(VALOR_TESTE));
        sysout(
            "%.3f K = %.3f Re",
            VALOR_TESTE,
            kelvinParaReaumur(VALOR_TESTE));
    }

    private static void printConversoesDeRankine() {

        sysout(
            "%.3f R = %.3f C",
            VALOR_TESTE,
            rankineParaCelsius(VALOR_TESTE));
        sysout(
            "%.3f R = %.3f F",
            VALOR_TESTE,
            rankineParaFahrenheit(VALOR_TESTE));
        sysout(
            "%.3f R = %.3f K",
            VALOR_TESTE,
            rankineParaKelvin(VALOR_TESTE));
        sysout(
            "%.3f R = %.3f Re",
            VALOR_TESTE,
            rankineParaReaumur(VALOR_TESTE));
    }

    private static void printConversoesDeReaumur() {

        sysout(
            "%.3f Re = %.3f C",
            VALOR_TESTE,
            reaumurParaCelsius(VALOR_TESTE));
        sysout(
            "%.3f Re = %.3f F",
            VALOR_TESTE,
            reaumurParaFahrenheit(VALOR_TESTE));
        sysout(
            "%.3f Re = %.3f K",
            VALOR_TESTE,
            reaumurParaKelvin(VALOR_TESTE));
        sysout(
            "%.3f Re = %.3f R",
            VALOR_TESTE,
            reaumurParaRankine(VALOR_TESTE));
    }
}
