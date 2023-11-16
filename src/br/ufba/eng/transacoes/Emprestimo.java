package br.ufba.eng.transacoes;

import br.ufba.eng.livro.IDados;
import br.ufba.eng.usuario.Usuario;

import java.time.LocalDate;

public class Emprestimo extends Transacao{
    private LocalDate dataDevolucao;
    private LocalDate dataAlugado;

    public Emprestimo(Usuario usuario, IDados livro) {
        super(usuario, livro);
        this.dataAlugado = LocalDate.now();
        this.dataDevolucao = this.dataAlugado.plusDays(usuario.getLimiteEmprestimo());
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public LocalDate getDataAlugado() {
        return dataAlugado;
    }
}
