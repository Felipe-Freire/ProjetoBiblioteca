package eng.itens;

import eng.transacoes.Emprestimo;

public interface IEmprestavel {
    void realizaEmprestimo(Emprestimo emprestimo);
    void removerEmprestimo(Emprestimo emprestimo);
}
