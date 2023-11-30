package br.ufba.eng.verificacao;

import br.ufba.eng.itens.Livro;
import br.ufba.eng.transacoes.Emprestimo;
import br.ufba.eng.transacoes.Reserva;
import br.ufba.eng.usuario.Usuario;

import java.util.ArrayList;

public class Verificador {
    public boolean verificaUsuarioELivro(Usuario usuario, Livro livro) {
        return verificarUsuario(usuario) && verificarLivro(livro);
    }

    public boolean verificarUsuario(Usuario usuario) {
        return usuario != null;
    }

    public boolean verificarLivro(Livro livro) {
        return livro != null;
    }


    public boolean verificaReserva(Usuario usuario, ArrayList<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaEstadoDevedor(Usuario usuario, Livro livro) {
        // Implemente a lógica de verificação do estado devedor do usuário para o livro
        return false;
    }


    public boolean verificaEmprestimo(Usuario usuario, Livro livro, ArrayList<Emprestimo> emprestimos) {
        usuario.getEstrategiaEmprestimo().aplicarEstrategia(usuario, livro);
        return false;
    }
}
