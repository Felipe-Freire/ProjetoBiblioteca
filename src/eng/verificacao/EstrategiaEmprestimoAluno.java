package eng.verificacao;

import eng.itens.Livro;
import eng.transacoes.Emprestimo;
import eng.transacoes.Reserva;
import eng.usuario.Usuario;

import java.util.ArrayList;

public class EstrategiaEmprestimoAluno implements IEstrategiaEmprestimo{
    @Override
    public boolean aplicarEstrategia(Usuario usuario, Livro livro, ArrayList<Reserva> reservas, ArrayList<Emprestimo> emprestimos) {
        // (i) Verifica disponibilidade
        if (livro.getQuantidadeDisponivel() == 0) {
            return false;
        }

        // (ii) Verifica se o usuário está "devedor" de algum livro em atraso
        if (Verificador.verificaEstadoDevedor(usuario, emprestimos)) {
            return false;
        }

        // (iii) Verifica quantidade máxima de empréstimos para o tipo de usuário
        if (!Verificador.verificaLiberdadeDeEmprestimo(usuario, emprestimos)) {
            return false;
        }

        // (iv) Verifica quantidade de reservas em relação à disponibilidade de exemplares
        if (!(livro.getQuantidadeReservas() < livro.getQuantidadeDisponivel())) {
            return false;
        }

        // (v) Verifica
        if(!(Verificador.verificaReserva(usuario, reservas) && livro.getQuantidadeReservas() >= livro.getQuantidadeTotal())) {
            return false;
        }

        // (vi) Verifica se o usuario ja tem o livro
        if (Verificador.verificaEmprestimo(usuario, livro, emprestimos)) {
            return false;
        }

        // Todas as condições foram atendidas, o empréstimo pode ser realizado
        return true;
    }
}
