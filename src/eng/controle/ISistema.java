package eng.controle;

import eng.itens.Livro;
import eng.usuario.IObservador;
import eng.usuario.Usuario;

public interface ISistema {

    public void adicionarObservador(Usuario usuario, Livro livro);

    public void consultarLivro(Livro livro);

    public void consultarUsuario(Usuario usuario);

    public void consultarProfessor(IObservador usuario);

    public void devolverLivro(Usuario usuario, Livro livro);

    public void emprestarLivro(Usuario usuario, Livro livro);

    public void reservarLivro(Usuario usuario, Livro livro);

    public void sairSistema();

}
