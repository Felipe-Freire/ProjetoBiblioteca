package eng.itens;

import eng.transacoes.Emprestimo;

public interface IEmprestavel {
    public void realizaEmprestimo(Emprestimo emprestimo);
    public void removerEmprestimo(Emprestimo emprestimo);
}
