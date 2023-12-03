package eng.verificacao;

import eng.exceptions.ErroDeNegocio;
import eng.itens.Livro;
import eng.transacoes.Emprestimo;
import eng.transacoes.Reserva;
import eng.usuario.Usuario;

import java.util.ArrayList;

public class EstrategiaEmprestimoProfessor implements IEstrategiaEmprestimo{
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

        // Todas as condições foram atendidas, o empréstimo pode ser realizado
        return true;
    }
}
