package br.ufba.eng.transacoes;

import br.ufba.eng.livro.IDados;
import br.ufba.eng.usuario.Usuario;


public abstract class Transacao {
    private Usuario usuario;
    private IDados livro;

    public Transacao(Usuario usuario, IDados livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public IDados getLivro() {
        return livro;
    }
}
