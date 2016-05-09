
package br.eng.augusteiner.poo.aulas;

import br.eng.augusteiner.poo.Circulo;
import br.eng.augusteiner.poo.Ponto;
import br.eng.augusteiner.poo.Triangulo;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Aula_25_04_16_POO {

    public static void main(String[] args) {

        Ponto p1 = new Ponto(0, 3);
        Ponto p2 = new Ponto(4, 0);

        System.out.println(String.format("Distancia do ponto %s a origem: %s", p1, p1.distanciaOrigem()));
        System.out.println(String.format("Distancia do ponto %s ao ponto %s: %s", p1, p2, p1.distancia(p2)));

        Triangulo t1 = new Triangulo(p1, p2, Ponto.ORIGEM);

        System.out.println("---------------------");

        System.out.println(String.format("Fatos do triângulo %s", t1));
        System.out.println(String.format("Perímetro do triângulo é: %s", t1.perimetro()));
        System.out.println(String.format("Area do triângulo é: %s", t1.area()));

        System.out.println("---------------------");

        Circulo c1 = new Circulo(Ponto.ORIGEM, p1);

        System.out.println(String.format("Fatos do circunferência %s", c1));
        System.out.println(String.format("Comprimento da circunferência: %s", c1.permimetro()));
        System.out.println(String.format("Área da circunferência: %s", c1.area()));
    }
}
