package br.ufba.eng.controle;

import br.ufba.eng.itens.ILivro;
import br.ufba.eng.transacoes.Emprestimo;
import br.ufba.eng.transacoes.Reserva;
import br.ufba.eng.usuario.Usuario;

import java.util.ArrayList;

public interface ISistema {
    public void adicionarUsuario(Usuario usuario);

    public Usuario pegarUsuarioPorCodigo(String id);

    public void adicionarItem(ILivro item);

    public ILivro pegarLivroPorCodigo(String id);

    public Emprestimo adicionaEmprestimo(Usuario usuario, ILivro item);

    public void removeEmprestimo(Usuario usuario, ILivro item);

    public Reserva adicionaReserva(Usuario usuario, ILivro item);

    public ArrayList<Emprestimo> pegaEmprestimosCodigoLivro(String id);

    public ArrayList<Reserva> pegaReservaCodigoLivro(String id);

}
