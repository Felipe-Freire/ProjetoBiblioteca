package br.ufba.eng.controle;

import br.ufba.eng.itens.Livro;
import br.ufba.eng.transacoes.Emprestimo;
import br.ufba.eng.transacoes.Reserva;
import br.ufba.eng.usuario.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class Sistema implements ISistema {
    private final HashMap<String, Livro> livros = new HashMap<>();
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
    public void adicionarObservador(Usuario usuario, Livro livro) {

    }

    @Override
    public void consultarLivro(Livro livro) {

    }

    @Override
    public void consultarUsuario(Usuario usuario) {

    }

    @Override
    public void devolverLivro(Usuario usuario, Livro livro) {

    }

    @Override
    public void emprestarLivro(Usuario usuario, Livro livro) {

    }

    @Override
    public void reservarLivro(Usuario usuario, Livro livro) {

    }

    protected void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getCodigo(), usuario);
    }

    protected Usuario pegarUsuarioPorCodigo(String codigo) {
        return usuarios.get(codigo);
    }

    protected void adicionarLivro(Livro livro) {
        livros.put(livro.getCodigo(), livro);
    }

    protected Livro pegarLivroPorCodigo(String codigo) {
        return livros.get(codigo);
    }

    protected Emprestimo adicionaEmprestimo(Usuario usuario, Livro livro) {
        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    protected void removeEmprestimo(Usuario usuario, Livro livro) {

    }

    protected Reserva adicionaReserva(Usuario usuario, Livro livro) {
        Reserva reserva = new Reserva(usuario, livro);
        reservas.add(reserva);
        return reserva;
    }

    protected ArrayList<Emprestimo> pegaEmprestimosCodigoLivro(String id) {
        ArrayList<Emprestimo> emprestimosDoLivro = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getCodigo().equals(id)) {
                emprestimosDoLivro.add(emprestimo);
            }
        }
        return emprestimosDoLivro;
    }

    protected ArrayList<Reserva> pegaReservaCodigoLivro(String id) {
        ArrayList<Reserva> reservasDoLivro = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getLivro().getCodigo().equals(id)) {
                reservasDoLivro.add(reserva);
            }
        }
        return reservasDoLivro;
    }
}
