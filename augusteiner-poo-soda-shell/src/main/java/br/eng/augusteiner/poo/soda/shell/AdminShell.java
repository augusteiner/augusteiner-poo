
package br.eng.augusteiner.poo.soda.shell;

import static br.eng.augusteiner.poo.Util.*;
import static br.eng.augusteiner.poo.soda.shell.App.*;

import java.io.IOException;

import com.budhash.cliche.Command;
import com.budhash.cliche.Param;
import com.budhash.cliche.Shell;
import com.budhash.cliche.ShellFactory;

import br.eng.augusteiner.poo.Maquina;
import br.eng.augusteiner.poo.Moeda;
import br.eng.augusteiner.poo.Produto;
import br.eng.augusteiner.poo.QuantidadeMoeda;
import br.eng.augusteiner.poo.QuantidadeProduto;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class AdminShell {

    static final Shell SHELL;

    private static final String PROGRAM_NAME = AdminShell.class.getSimpleName();

    private static int tentativas = 0;

    static {

        SHELL = ShellFactory.createSubshell(
            "#",
            ConsumidorShell.SHELL,
            PROGRAM_NAME,
            new AdminShell());
    }

    private static Maquina getMaquina() {

        return Maquina.getSingleton();
    }

    public static void iniciar() throws IOException {

        if (!isAdminAutenticado()) {

            exibirAlerta("Admin deve inserir chave de acesso.");

            return;
        }

        tentativas = 0;

        SHELL.commandLoop();
    }

    private static boolean isAdminAutenticado() {

        tentativas++;

        return tentativas > 1;
    }

    @Command
    public void cadastrarProduto() {

        print("Informe o código do produto: ");
        String codigo = lerString();

        cadastrarProduto(codigo);
    }

    @Command
    public void cadastrarProduto(
        @Param(name = "Código", description = "Código do Refrigerante")
        String codigo) {

        cadastrarProduto(
            codigo,
            0);
    }

    @Command
    public void cadastrarProduto(
        @Param(name = "Código", description = "Código do Refrigerante")
        String codigo,
        @Param(name = "Qte", description = "Quantas unidades do Refrigerante")
        int qte) {

        print("Informe a descrição do produto: ");
        String descricao = lerString();

        cadastrarProduto(
            codigo,
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

        print("Informe o preço: ");
        double preco = lerDouble();

        cadastrarProduto(
            codigo,
            descricao,
            qte,
            preco);
    }

    @Command
    public void cadastrarProduto(
        @Param(name = "Código", description = "Código do Refrigerante")
        String codigo,
        @Param(name = "Descrição", description = "Descrição do Refrigerante")
        String descricao,
        @Param(name = "Qte", description = "Quantas unidades do Refrigerante")
        int qte,
        @Param(name = "Preço", description = "Preço do Refrigerante")
        double preco) {

        Produto produto = new Produto(
            codigo.toUpperCase(),
            descricao.replace("_", " "),
            preco);

        getMaquina().addProduto(
            produto,
            qte);

        exibirProduto(produto);
    }

    public void inserirMoeda(Moeda moeda) {

        inserirMoeda(
            moeda,
            1);
    }

    public void inserirMoeda(
        Moeda moeda,
        int quantidade) {

        for (int i = 0; i < quantidade; i++) {

            getMaquina().addMoeda(moeda);

            exibirMensagem(
                "Moeda '%s' inserida",
                moeda);
        }
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m1",
        name = "m1")
    public void inserirMoeda1() {

        inserirMoeda1(1);
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m1",
        name = "m1")
    public void inserirMoeda1(int qte) {

        inserirMoeda(
            Moeda.doValor(1),
            qte);
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m10",
        name = "m10")
    public void inserirMoeda10() {

        inserirMoeda10(1);
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m10",
        name = "m10")
    public void inserirMoeda10(int qte) {

        inserirMoeda(
            Moeda.doValor(0.10),
            qte);
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m25",
        name = "m25")
    public void inserirMoeda25() {

        inserirMoeda25(1);
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m25",
        name = "m25")
    public void inserirMoeda25(int qte) {

        inserirMoeda(
            Moeda.doValor(0.25),
            qte);
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m5",
        name = "m5")
    public void inserirMoeda5() {

        inserirMoeda5(1);
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m5",
        name = "m5")
    public void inserirMoeda5(int qte) {

        inserirMoeda(
            Moeda.doValor(0.05),
            qte);
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m50",
        name = "m50")
    public void inserirMoeda50() {

        inserirMoeda50(1);
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m50",
        name = "m50")
    public void inserirMoeda50(int qte) {

        inserirMoeda(
            Moeda.doValor(0.50),
            qte);
    }

    @Command(description = "Repõe produto já cadastrado no estoque")
    public void reporEstoque(
        @Param(name = "Código", description = "Código do Refrigerante")
        String codigo,
        @Param(name = "Qte", description = "Quantas unidades do Refrigerante")
        int qte) {

        codigo = codigo.toUpperCase();

        Produto produto = getMaquina().produto(codigo);

        if (produto == null) {

            exibirErro(
                "Produto #%s não encontrado",
                codigo);

            return;
        }

        getMaquina().addProduto(
            produto,
            qte);

        System.out.println(String.format(
            "Adicionadas %s %s ao estoque",
            qte,
            produto));
    }

    @Command
    public void verEstoque() {

        for (QuantidadeProduto qte : getMaquina().getEstoque()) {

            exibirProduto(qte);
        }
    }

    @Command
    public void verMoedas() {

        for (QuantidadeMoeda qte : getMaquina().getMoedas()) {

            exibirMoeda(qte);
        }
    }
}
