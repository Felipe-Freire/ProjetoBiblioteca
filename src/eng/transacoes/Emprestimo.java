package eng.transacoes;

import eng.itens.Livro;
import eng.usuario.Usuario;

import java.time.LocalDate;

public class Emprestimo extends Transacao{
    private final LocalDate dataDevolucao;
    private final LocalDate dataAlugado;
    private LocalDate dataEntregue;
    private boolean finalizado;

    public Emprestimo(Usuario usuario, Livro livro) {
        super(usuario, livro);
        this.dataAlugado = LocalDate.now();
        this.dataDevolucao = this.dataAlugado.plusDays(usuario.getLimiteEmprestimo());
        this.finalizado = false;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public LocalDate getDataAlugado() {
        return dataAlugado;
    }

    public LocalDate getDataEntregue() {
        return dataEntregue;
    }

    public void setDataEntregue(LocalDate dataEntregue) {
        this.dataEntregue = dataEntregue;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
