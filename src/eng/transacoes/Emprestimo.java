package eng.transacoes;

import eng.itens.Livro;
import eng.usuario.Usuario;

import java.time.LocalDate;

public class Emprestimo extends Transacao{
    private LocalDate dataDevolucao;
    private LocalDate dataAlugado;

    public Emprestimo(Usuario usuario, Livro livro) {
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