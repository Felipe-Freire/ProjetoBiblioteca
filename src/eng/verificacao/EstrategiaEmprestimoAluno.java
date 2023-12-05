package eng.verificacao;

import eng.exceptions.ErroDeNegocio;
import eng.itens.Livro;
import eng.transacoes.Emprestimo;
import eng.transacoes.Reserva;
import eng.usuario.Usuario;

import java.util.ArrayList;

public class EstrategiaEmprestimoAluno implements IEstrategiaEmprestimo{
    @Override
    public boolean aplicarEstrategia(Usuario usuario, Livro livro, ArrayList<Reserva> reservas, ArrayList<Emprestimo> emprestimos) throws ErroDeNegocio {
        // (i) Verifica disponibilidade
        if (livro.getQuantidadeDisponivel() == 0) {
            throw new ErroDeNegocio("Livro não disponível para empréstimo.");
        }

        // (ii) Verifica se o usuário está "devedor" de algum livro em atraso
        if (Verificador.verificaEstadoDevedor(usuario, emprestimos)) {
            throw new ErroDeNegocio("Usuário está em débito com a biblioteca.");
        }

        // (iii) Verifica quantidade máxima de empréstimos para o tipo de usuário
        if (!Verificador.verificaLiberdadeDeEmprestimo(usuario)) {
            throw new ErroDeNegocio("Usuário atingiu a quantidade máxima de empréstimos permitida.");
        }

        if (!(Verificador.verificaReserva(usuario, reservas))) {
            // (iv) Verifica quantidade de reservas em relação à disponibilidade de exemplares
            if (!(livro.getQuantidadeReservas() < livro.getQuantidadeDisponivel())) {
                throw new ErroDeNegocio("Não há exemplares disponíveis para atender às reservas.");
            }
        }

        // (vi) Verifica se o usuario ja tem o livro
        if (Verificador.verificaEmprestimo(usuario, livro, emprestimos)) {
            throw new ErroDeNegocio("Usuário já possui o livro emprestado.");
        }

        // Todas as condições foram atendidas, o empréstimo pode ser realizado
        return true;
    }
}
