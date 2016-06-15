
package br.eng.augusteiner.poo.aulas;

import static br.eng.augusteiner.poo.Util.println;

import br.eng.augusteiner.poo.Circulo;
import br.eng.augusteiner.poo.Ponto;
import br.eng.augusteiner.poo.Triangulo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_16_04_25_POO {

    public static void main(String[] args) {

        Ponto p1 = new Ponto(0, 3);
        Ponto p2 = new Ponto(4, 0);

        println("Distancia do ponto %s a origem: %s", p1, p1.distanciaOrigem());
        println("Distancia do ponto %s ao ponto %s: %s", p1, p2, p1.distancia(p2));

        Triangulo t1 = new Triangulo(p1, p2, Ponto.ORIGEM);

        println("---------------------");

        println("Fatos do triângulo %s", t1);
        println("Perímetro do triângulo é: %s", t1.perimetro());
        println("Area do triângulo é: %s", t1.area());

        println("---------------------");

        Circulo c1 = new Circulo(Ponto.ORIGEM, p1);

        println("Fatos do circunferência %s", c1);
        println("Comprimento da circunferência: %s", c1.permimetro());
        println("Área da circunferência: %s", c1.area());
    }
}
