package br.ufba.eng.controle;

import br.ufba.eng.itens.Livro;
import br.ufba.eng.transacoes.Emprestimo;
import br.ufba.eng.transacoes.Reserva;
import br.ufba.eng.usuario.Usuario;

import java.util.ArrayList;

public interface ISistema {

    public void adicionarObservador(Usuario usuario, Livro livro);

    public void consultarLivro(Livro livro);

    public void consultarUsuario(Usuario usuario);

    public void devolverLivro(Usuario usuario, Livro livro);

    public void emprestarLivro(Usuario usuario, Livro livro);

    public void reservarLivro(Usuario usuario, Livro livro);

}
