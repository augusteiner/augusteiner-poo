
package generics.aula;

import generics.aula.basico.Funcao;
import generics.aula.funcoes.FuncaoComposta;
import generics.aula.funcoes.FuncaoQuadratica;
import generics.aula.funcoes.StringEmbaralhada;
import generics.aula.funcoes.StringInversa;
import generics.aula.funcoes.StringMaiuscula;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Generics_02_Exemplo_Funcoes {

    public static void main(String[] args) {

        // XXX func1: 2x² + 3x + 2
        Funcao<Double> funcQuad = new FuncaoQuadratica(2.0, 3.0, 2.0);

        Funcao<String> funcInverter = new StringInversa();
        Funcao<String> funcEmbaralhar = new StringEmbaralhada();
        Funcao<String> funcMaiuscula = new StringMaiuscula();

        Funcao<String> func6 = new FuncaoComposta<String>(funcInverter, funcMaiuscula);

        sysout("Função quád.: " + funcQuad.calcular(2.0));

        String hello = "!dlroW olleH";

        sysout("Embaralhada: " + funcEmbaralhar.calcular("Generics<T>"));

        sysout("Inversa: " + funcInverter.calcular(hello));

        sysout("Composta: " + func6.calcular(hello));
    }

    private static void sysout(String string) {

        System.out.println(string);
    }
}
