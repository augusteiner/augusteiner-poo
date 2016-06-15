
package br.eng.augusteiner.poo;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class PessoaFisica extends Pessoa {

    public static final String CPF_MASK = "###.###.###-##";
    public static final MaskFormatter CPF_FORMATTER = new MaskFormatter();

    static {

        try {

            CPF_FORMATTER.setMask(CPF_MASK);
            CPF_FORMATTER.setValueContainsLiteralCharacters(false);

        } catch (ParseException e) {

            e.printStackTrace();
        }
    }

    public static void verificarCpf(String cpf) {

        if (cpf.length() != 11) {

            throw new IllegalArgumentException("CPF deve conter 11 dígitos");
        }

        for (int i = 0; i < cpf.length(); i++) {

            if (!Character.isDigit(cpf.charAt(i))) {

                throw new IllegalArgumentException("CPF deve conter apenas números");
            }
        }
    }

    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String cpf) {

        super(nome);

        verificarCpf(cpf);

        this.cpf = cpf;
    }

    public String getCpf() {

        return cpf;
    }

    public String toString() {

        return String.format(
            "#%s ~> %s",
            this.getCpfFormatado(),
            this.getNome());
    }

    private String getCpfFormatado() {

        try {

            return CPF_FORMATTER.valueToString(this.getCpf()).toString();
        } catch (ParseException e) {

            e.printStackTrace();

            return this.getCpf();
        }
    }
}
