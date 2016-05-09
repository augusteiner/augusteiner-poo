
package br.eng.augusteiner.poo.lista2;

import static br.eng.augusteiner.poo.ConversaoDeTemperatura.*;
import static br.eng.augusteiner.poo.Util.println;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q20_Conversao_Temperatura {

    public static final double VALOR_TESTE = 1;

    public static void main(String[] args) {

        printConversoesDeCelsius();
        println("-----------");

        printConversoesDeFahrenheit();
        println("-----------");

        printConversoesDeKelvin();
        println("-----------");

        printConversoesDeRankine();
        println("-----------");

        printConversoesDeReaumur();
    }

    private static void printConversoesDeCelsius() {

        println(
            "%.3f C = %.3f F",
            VALOR_TESTE,
            celsiusParaFahrenheit(VALOR_TESTE));
        println(
            "%.3f C = %.3f K",
            VALOR_TESTE,
            celsiusParaKelvin(VALOR_TESTE));
        println(
            "%.3f C = %.3f R",
            VALOR_TESTE,
            celsiusParaRankine(VALOR_TESTE));
        println(
            "%.3f C = %.3f Re",
            VALOR_TESTE,
            celsiusParaReaumur(VALOR_TESTE));
    }

    private static void printConversoesDeFahrenheit() {

        println(
            "%.3f F = %.3f C",
            VALOR_TESTE,
            fahrenheitParaCelsius(VALOR_TESTE));
        println(
            "%.3f F = %.3f K",
            VALOR_TESTE,
            fahrenheitParaKelvin(VALOR_TESTE));
        println(
            "%.3f F = %.3f R",
            VALOR_TESTE,
            fahrenheitParaRankine(VALOR_TESTE));
        println(
            "%.3f F = %.3f Re",
            VALOR_TESTE,
            fahrenheitParaReaumur(VALOR_TESTE));
    }

    private static void printConversoesDeKelvin() {

        println(
            "%.3f K = %.3f C",
            VALOR_TESTE,
            kelvinParaCelsius(VALOR_TESTE));
        println(
            "%.3f K = %.3f F",
            VALOR_TESTE,
            kelvinParaFahrenheit(VALOR_TESTE));
        println(
            "%.3f K = %.3f R",
            VALOR_TESTE,
            kelvinParaRankine(VALOR_TESTE));
        println(
            "%.3f K = %.3f Re",
            VALOR_TESTE,
            kelvinParaReaumur(VALOR_TESTE));
    }

    private static void printConversoesDeRankine() {

        println(
            "%.3f R = %.3f C",
            VALOR_TESTE,
            rankineParaCelsius(VALOR_TESTE));
        println(
            "%.3f R = %.3f F",
            VALOR_TESTE,
            rankineParaFahrenheit(VALOR_TESTE));
        println(
            "%.3f R = %.3f K",
            VALOR_TESTE,
            rankineParaKelvin(VALOR_TESTE));
        println(
            "%.3f R = %.3f Re",
            VALOR_TESTE,
            rankineParaReaumur(VALOR_TESTE));
    }

    private static void printConversoesDeReaumur() {

        println(
            "%.3f Re = %.3f C",
            VALOR_TESTE,
            reaumurParaCelsius(VALOR_TESTE));
        println(
            "%.3f Re = %.3f F",
            VALOR_TESTE,
            reaumurParaFahrenheit(VALOR_TESTE));
        println(
            "%.3f Re = %.3f K",
            VALOR_TESTE,
            reaumurParaKelvin(VALOR_TESTE));
        println(
            "%.3f Re = %.3f R",
            VALOR_TESTE,
            reaumurParaRankine(VALOR_TESTE));
    }
}
