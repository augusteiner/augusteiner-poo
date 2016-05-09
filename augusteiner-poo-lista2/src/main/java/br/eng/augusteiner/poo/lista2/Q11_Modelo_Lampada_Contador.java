
package br.eng.augusteiner.poo.lista2;

import static br.eng.augusteiner.poo.Util.println;

import br.eng.augusteiner.poo.Lampada;
import br.eng.augusteiner.poo.LampadaContador;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q11_Modelo_Lampada_Contador {

    public static void main(String[] args) {

        Lampada lampada2 = new LampadaContador();

        lampada2.acender();
        lampada2.acender();

        println(
            "Lâmpada: %s",
            lampada2);
        lampada2.apagar();
        lampada2.acender();
        lampada2.meiaLuz();

        println(
            "Lâmpada: %s",
            lampada2);
    }
}
