package eng.verificacao;

import eng.itens.Livro;
import eng.transacoes.Emprestimo;
import eng.transacoes.Reserva;
import eng.usuario.Usuario;

import java.util.ArrayList;

public class Verificador {
    public static boolean verificaReserva(Usuario usuario, ArrayList<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificaEstadoDevedor(Usuario usuario, ArrayList<Emprestimo> emprestimos) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario)) {
                if (emprestimo.getDataAlugado().isAfter(emprestimo.getDataDevolucao())){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verificaEmprestimo(Usuario usuario, Livro livro, ArrayList<Emprestimo> emprestimos) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario) && emprestimo.getLivro().equals(livro)) {
                return true;  // Já existe um empréstimo para o usuário e livro específicos
            }
        }
        return false;
    }

    public static boolean verificaLiberdadeDeEmprestimo(Usuario usuario) {
        return usuario.getLimiteEmprestimo() > usuario.getQuantLivrosEmprestados();
    }

    public static boolean verificaLiberdadeDeReserva(Usuario usuario) {
        return usuario.getLimiteReservas() > usuario.getQuantLivrosReservados();
    }
}
