
package br.eng.augusteiner.poo.soda.shell;

import static br.eng.augusteiner.poo.Util.*;
import static br.eng.augusteiner.poo.soda.shell.App.*;

import java.io.IOException;

import com.budhash.cliche.Command;
import com.budhash.cliche.Param;
import com.budhash.cliche.ShellFactory;

import br.eng.augusteiner.poo.Produto;
import br.eng.augusteiner.poo.QuantidadeMoeda;
import br.eng.augusteiner.poo.QuantidadeProduto;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class AdminShell {

    public static final String PROGRAM_NAME = AdminShell.class.getSimpleName();

    private static int tentativas = 0;

    public static void iniciar() throws IOException {

        if (!isAdminAutenticado()) {

            exibirAlerta("Admin deve inserir chave de acesso.");

            return;
        }

        tentativas = 0;

        ShellFactory.createConsoleShell(
            "#",
            PROGRAM_NAME,
            new AdminShell()).commandLoop();
    }

    private static boolean isAdminAutenticado() {

        tentativas++;

        return tentativas > 1;
    }

    @Command
    public void cadastrarProduto() {

        print("Informe o código do produto: ");
        String codigo = lerString().toUpperCase();

        cadastrarProduto(codigo);
    }

    @Command
    public void cadastrarProduto(
        @Param(name = "Código", description = "Código do Refrigerante")
        String codigo) {

        cadastrarProduto(
            codigo.toUpperCase(),
            0);
    }

    @Command
    public void cadastrarProduto(
        @Param(name = "Código", description = "Código do Refrigerante")
        String codigo,
        @Param(name = "Código", description = "Código do Refrigerante")
        int qte) {

        print("Informe a descrição do produto: ");
        String descricao = lerString();

        cadastrarProduto(
            codigo.toUpperCase(),
            descricao,
            qte);
    }

    @Command
    public void cadastrarProduto(
        @Param(name = "Código", description = "Código do Refrigerante")
        String codigo,
        @Param(name = "Descrição", description = "Descrição do Refrigerante")
        String descricao,
        @Param(name = "Qte", description = "Quantas unidades do Refrigerante")
        int qte) {

        print("Informe o preço do produto: ");
        double preco = lerDouble();

        Produto produto = new Produto(
            codigo.toUpperCase(),
            descricao,
            preco);

        MAQUINA.addProduto(produto, qte);

        exibirProduto(produto);
    }

    @Command(description = "Repõe produto já cadastrado no estoque")
    public void reporEstoque(
        @Param(name = "Código", description = "Código do Refrigerante")
        String codigo,
        @Param(name = "Qte", description = "Quantas unidades do Refrigerante")
        int quantidade) {

        codigo = codigo.toUpperCase();

        Produto produto = MAQUINA.produto(codigo);

        if (produto == null) {

            exibirErro(
                "Produto #%s não encontrado",
                codigo);

            return;
        }

        MAQUINA.addProduto(
            produto,
            quantidade);

        System.out.println(String.format(
            "Adicionadas %s %s ao estoque",
            quantidade,
            produto));
    }

    @Command
    public void verMoedas() {

        for (QuantidadeMoeda qte : MAQUINA.getMoedas()) {

            exibirMoedas(qte);
        }
    }

    @Command
    public void verEstoque() {

        for (QuantidadeProduto qte : MAQUINA.getEstoque()) {

            exibirProduto(qte);
        }
    }
}
