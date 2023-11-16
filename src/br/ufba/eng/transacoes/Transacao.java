package br.ufba.eng.transacoes;

import br.ufba.eng.livro.Livro;
import br.ufba.eng.usuario.Usuario;

import java.time.LocalDate;

public class Transacao {
    private Usuario usuario;
    private Livro livro;

    public Transacao(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }
}
