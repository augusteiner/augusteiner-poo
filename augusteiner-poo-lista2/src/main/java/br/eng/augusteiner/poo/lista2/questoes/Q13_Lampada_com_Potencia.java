
package br.eng.augusteiner.poo.lista2.questoes;

import static br.eng.augusteiner.poo.lista2.Util.println;

import br.eng.augusteiner.poo.lista2.classes.Lampada;
import br.eng.augusteiner.poo.lista2.classes.LampadaComPotencia;

/**
 * @author José Nascimento joseaugustodearaujonascimento@gmail.com
 */
public class Q13_Lampada_com_Potencia {

    public static void main(String[] args) {

        Lampada l1 = new LampadaComPotencia();
        Lampada l2 = new LampadaComPotencia(45);

        println("Lâmpada padrão: %s", l1);
        println("Lâmpada normal: %s", l2);
    }
}
