package br.ufba.eng.controle;

import br.ufba.eng.itens.ILivro;
import br.ufba.eng.transacoes.Emprestimo;
import br.ufba.eng.transacoes.Reserva;
import br.ufba.eng.usuario.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class Sistema implements ISistema {
    private final HashMap<String, ILivro> livros = new HashMap<>();
    private final HashMap<String, Usuario> usuarios = new HashMap<>();
    private final ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private final ArrayList<Reserva> reservas = new ArrayList<>();

    private Sistema() {}

    private static Sistema instance;

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getCodigo(), usuario);
    }

    @Override
    public Usuario pegarUsuarioPorCodigo(String codigo) {
        return usuarios.get(codigo);
    }

    @Override
    public void adicionarItem(ILivro livro) {
        livros.put(livro.getCodigo(), livro);
    }

    @Override
    public ILivro pegarLivroPorCodigo(String codigo) {
        return livros.get(codigo);
    }

    @Override
    public Emprestimo adicionaEmprestimo(Usuario usuario, ILivro livro) {
        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    @Override
    public void removeEmprestimo(Usuario usuario, ILivro livro) {

    }

    @Override
    public Reserva adicionaReserva(Usuario usuario, ILivro livro) {
        Reserva reserva = new Reserva(usuario, livro);
        reservas.add(reserva);
        return reserva;
    }

    @Override
    public ArrayList<Emprestimo> pegaEmprestimosCodigoLivro(String id) {
        ArrayList<Emprestimo> emprestimosDoILivro = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getCodigo().equals(id)) {
                emprestimosDoILivro.add(emprestimo);
            }
        }
        return emprestimosDoILivro;
    }

    @Override
    public ArrayList<Reserva> pegaReservaCodigoLivro(String id) {
        ArrayList<Reserva> reservasDoILivro = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getLivro().getCodigo().equals(id)) {
                reservasDoILivro.add(reserva);
            }
        }
        return reservasDoILivro;
    }


}
