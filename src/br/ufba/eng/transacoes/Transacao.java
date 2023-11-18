package br.ufba.eng.transacoes;

import br.ufba.eng.itens.ILivro;
import br.ufba.eng.usuario.Usuario;


public abstract class Transacao {
    private Usuario usuario;
    private ILivro livro;

    public Transacao(Usuario usuario, ILivro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ILivro getLivro() {
        return livro;
    }
}
