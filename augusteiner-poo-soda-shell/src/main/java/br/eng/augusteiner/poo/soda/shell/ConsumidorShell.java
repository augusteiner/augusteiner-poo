
package br.eng.augusteiner.poo.soda.shell;

import static br.eng.augusteiner.poo.soda.Util.*;
import static br.eng.augusteiner.poo.Util.*;
import static br.eng.augusteiner.poo.Compra.*;
import static br.eng.augusteiner.poo.soda.shell.App.*;

import java.io.IOException;

import com.budhash.cliche.Command;
import com.budhash.cliche.Param;
import com.budhash.cliche.Shell;
import com.budhash.cliche.ShellFactory;

import br.eng.augusteiner.poo.Compra;
import br.eng.augusteiner.poo.Maquina;
import br.eng.augusteiner.poo.Moeda;
import br.eng.augusteiner.poo.Produto;
import br.eng.augusteiner.poo.QuantidadeMoeda;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ConsumidorShell {

    public static final String PROGRAM_NAME = ConsumidorShell.class.getSimpleName();
    static final Shell SHELL;

    static {

        SHELL = ShellFactory.createConsoleShell(
            "$",
            PROGRAM_NAME,
            new ConsumidorShell());
    }

    public static void iniciar() throws IOException {

        SHELL.commandLoop();
    }

    @Command(
        description = "Iniciar console de adm. da máquina de refris",
        abbrev = "admin",
        name = "admin")
    public void admin() throws IOException {

        AdminShell.iniciar();
    }

    private Produto buscarRefrigerante(String codigo) {

        return getMaquina().produtoDisponivel(codigo.toUpperCase());
    }

    public void exibirCompra(Compra compra) {

        exibirMensagem("Compra realizada com sucesso!");

        exibirProduto(compra.getProduto());

        println(
            "Recebido: %s",
            compra.getValorEntrada());

        println(
            "Troco: %s",
            compra.getValorTroco());

        for (QuantidadeMoeda qte : compra.getTroco()) {

            for (int i = 0; i < qte.getQuantidade(); i++) {

                exibirMensagem(
                    "Dispensando moeda: %s",
                    qte.getMoeda());
            }
        }
    }

    private Maquina getMaquina() {

        return Maquina.getSingleton();
    }

    public void inserirMoeda(double valor) {

        Moeda moeda = Moeda.doValor(valor);

        if (getMaquina().getCompraAtual() == null) {

            getMaquina().novaCompra();
        }

        getMaquina().inserirMoeda(moeda);

        exibirMensagem(
            "Moeda 'R$ %.2f' inserida",
            moeda.getValor());
    }

    @Command(
        description = "Inserir moeda de R$ 1,00",
        abbrev = "m1",
        name = "m1")
    public void inserirMoeda1() {

        inserirMoeda(1);
    }

    @Command(
        description = "Inserir moeda de R$ 0,10",
        abbrev = "m10",
        name = "m10")
    public void inserirMoeda10() {

        inserirMoeda(0.10);
    }

    @Command(
        description = "Inserir moeda de R$ 0,25",
        abbrev = "m25",
        name = "m25")
    public void inserirMoeda25() {

        inserirMoeda(0.25);
    }

    @Command(
        description = "Inserir moeda de R$ 0,05",
        abbrev = "m5",
        name = "m5")
    public void inserirMoeda5() {

        inserirMoeda(0.05);
    }

    @Command(
        description = "Inserir moeda de R$ 0,50",
        abbrev = "m50",
        name = "m50")
    public void inserirMoeda50() {

        inserirMoeda(0.50);
    }

    @Command(description = "Listar refrigerantes")
    public void listar() {

        for (Produto produto : getMaquina().getProdutosDisponiveis()) {

            exibirProduto(produto);
        }
    }

    @Command(description = "Listar refrigerantes")
    public void resumoCompra() {

        Compra compra = getMaquina().getCompraAtual();

        if (compra != null) {

            println("Resumo da Compra");
            println(compra.getValorEntrada());
            println(compra.getProduto());
        } else {

            println("Compra ainda não iniciada");
        }
    }

    @Command(description = "Retirar produtos")
    public void retirarProduto() {

        if (getMaquina().getCompraAtual() == null) {

            exibirAlerta("Compra ainda não iniciada");
        }

        Compra compra = getMaquina().encerrarCompra();

        if ((compra.getStatus() & STATUS_OK) == STATUS_OK) {

            exibirCompra(compra);

        } else {

            exibirMensagem(
                "Compra não realizada: %s",
                compra.getStatusAsString());

        }
    }

    @Command(description = "Seleção de refrigerante")
    public void selecionarProduto(
        @Param(name = "Código", description = "Código do refrigerante")
        String codigo) {

        Produto produto = buscarRefrigerante(codigo.toUpperCase());

        if (produto != null) {

             getMaquina().getCompraAtual().setProduto(produto);
        } else {

            exibirAlerta(
                "Refrigerante #%s não encontrado!",
                codigo);
        }
    }
}
