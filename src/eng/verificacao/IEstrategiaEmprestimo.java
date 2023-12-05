package eng.verificacao;

import eng.exceptions.ErroDeNegocio;
import eng.itens.Livro;
import eng.transacoes.Emprestimo;
import eng.transacoes.Reserva;
import eng.usuario.Usuario;

import java.util.ArrayList;

public interface IEstrategiaEmprestimo {
    boolean aplicarEstrategia(Usuario usuario, Livro livro, ArrayList<Reserva> reservas, ArrayList<Emprestimo> emprestimos) throws ErroDeNegocio;
}
