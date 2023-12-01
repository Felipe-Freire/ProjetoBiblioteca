package eng.transacoes;

import eng.itens.Livro;
import eng.usuario.Usuario;


public abstract class Transacao {
    private final Usuario usuario;
    private final Livro livro;

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
