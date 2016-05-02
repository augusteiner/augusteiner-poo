
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.Util.sysout;

import br.eng.augusteiner.poo.lista2.Lampada;
import br.eng.augusteiner.poo.lista2.LampadaContador;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q11_Modelo_Lampada_Contador {

    public static void main(String[] args) {

        Lampada lampada2 = new LampadaContador();

        lampada2.acender();
        lampada2.acender();

        sysout(
            "Lâmpada: %s",
            lampada2);
        lampada2.apagar();
        lampada2.acender();
        lampada2.meiaLuz();

        sysout(
            "Lâmpada: %s",
            lampada2);
    }
}
