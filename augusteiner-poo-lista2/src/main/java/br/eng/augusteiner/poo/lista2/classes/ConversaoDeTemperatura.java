
package br.eng.augusteiner.poo.lista2.classes;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class ConversaoDeTemperatura {

    public static double celsiusParaFahrenheit(double valor) {

        return (valor * 9 / 5) + 32;
    }

    public static double celsiusParaKelvin(double valor) {

        return valor + 273.15;
    }

    public static double celsiusParaRankine(double valor) {

        return fahrenheitParaRankine(celsiusParaFahrenheit(valor));
    }

    public static double celsiusParaReaumur(double valor) {

        return valor * 4 / 5;
    }

    public static double fahrenheitParaCelsius(double valor) {

        return (valor - 32) * 5 / 9;
    }

    public static double fahrenheitParaKelvin(double valor) {

        return celsiusParaKelvin(fahrenheitParaCelsius(valor));
    }

    public static double fahrenheitParaRankine(double valor) {

        return kelvinParaRankine(fahrenheitParaKelvin(valor));
    }

    public static double fahrenheitParaReaumur(double valor) {

        return celsiusParaReaumur(fahrenheitParaCelsius(valor));
    }

    public static double kelvinParaCelsius(double valor) {

        return valor - 273.15;
    }

    public static double kelvinParaFahrenheit(double valor) {

        return celsiusParaFahrenheit(kelvinParaCelsius(valor));
    }

    public static double kelvinParaRankine(double valor) {

        return valor * 1.8;
    }

    public static double kelvinParaReaumur(double valor) {

        return celsiusParaReaumur(kelvinParaCelsius(valor));
    }

    public static double rankineParaCelsius(double valor) {

        return kelvinParaCelsius(rankineParaKelvin(valor));
    }

    public static double rankineParaFahrenheit(double valor) {

        return celsiusParaFahrenheit(rankineParaCelsius(valor));
    }

    public static double rankineParaKelvin(double valor) {

        return valor / 1.8;
    }

    public static double rankineParaReaumur(double valor) {

        return kelvinParaReaumur(rankineParaKelvin(valor));
    }

    public static double reaumurParaCelsius(double valor) {

        return valor * 5 / 4;
    }

    public static double reaumurParaFahrenheit(double valor) {

        return celsiusParaFahrenheit(reaumurParaCelsius(valor));
    }

    public static double reaumurParaKelvin(double valor) {

        return celsiusParaKelvin(reaumurParaCelsius(valor));
    }

    public static double reaumurParaRankine(double valor) {

        return celsiusParaRankine(reaumurParaCelsius(valor));
    }
}
