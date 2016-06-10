
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

    private static final class Holder {

        private static final Shell INSTANCIA = ShellFactory.createConsoleShell(
            "$",
            PROGRAM_NAME,
            new ConsumidorShell());

        private static final Shell getSingleton() {

            return INSTANCIA;
        }
    }

    public static final String PROGRAM_NAME = ConsumidorShell.class.getSimpleName();

    public static void exibirCompra(Compra compra) {

        exibirProduto(compra.getProduto());

        exibirMensagem(String.format(
            LOCALE_PADRAO,
            "Recebido: %.2f",
            compra.getValorEntrada()));

        exibirMensagem(String.format(
            LOCALE_PADRAO,
            "Troco: %.2f",
            compra.getValorTroco()));

        for (QuantidadeMoeda qte : compra.getTroco()) {

            for (int i = 0; i < qte.getQuantidade(); i++) {

                exibirMensagem(
                    "Dispensada moeda: %s",
                    qte.getMoeda());
            }
        }
    }

    public static Shell getShellAtual() {

        return Holder.getSingleton();
    }

    public static void iniciar() throws IOException {

        getShellAtual().commandLoop();
    }

    @Command(
        description = "Iniciar console de adm. da máquina de refris",
        abbrev = "admin",
        name = "admin")
    public void admin() throws IOException {

        AdminShell.iniciar();
    }

    private Produto buscarRefrigerante(String codigo) {

        return getMaquina().produtoDisponivel(codigo);
    }

    private Maquina getMaquina() {

        return Maquina.getSingleton();
    }

    public void inserirMoeda(double valor) {

        Moeda moeda = Moeda.doValor(valor);

        getMaquina().novaCompra();

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

        for (Produto produto : getMaquina().produtosDisponiveis()) {

            exibirProduto(produto);
        }
    }

    @Command(description = "Ver resumo da compra")
    public void resumoCompra() {

        Compra compra = getMaquina().getCompraAtual();

        if (compra != null) {

            exibirProduto("Resumo da Compra");

            exibirProduto(String.format(
                LOCALE_PADRAO,
                "Total inserido: %.2f",
                compra.getValorEntrada()));

            exibirProduto(String.format(
                "Produto: %s",
                compra.getProduto()));

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

            exibirMensagem("Compra realizada com sucesso!");

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

        codigo = codigo.toUpperCase();

        Produto produto = this.buscarRefrigerante(codigo);

        if (produto != null) {

            getMaquina().novaCompra();

            getMaquina().getCompraAtual().setProduto(produto);

        } else {

            exibirAlerta(
                "Refrigerante #%s não disponível!",
                codigo);
        }
    }
}
