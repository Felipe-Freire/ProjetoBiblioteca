package eng.verificacao;

import eng.itens.Livro;
import eng.transacoes.Emprestimo;
import eng.transacoes.Reserva;
import eng.usuario.Usuario;

import java.util.ArrayList;

public class EstrategiaEmprestimoProfessor implements IEstrategiaEmprestimo{
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

        // Todas as condições foram atendidas, o empréstimo pode ser realizado
        return true;
    }
}
