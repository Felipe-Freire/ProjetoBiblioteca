package eng.controle;

import eng.itens.Livro;
import eng.usuario.Usuario;

public class ComandoAdicionarObservador implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];
        String codigoLivro = parametros[1];

        Usuario usuario = Sistema.getInstance().pegarUsuarioPorCodigo(codigoUsuario);
        Livro livro = Sistema.getInstance().pegarLivroPorCodigo(codigoLivro);

        Sistema.getInstance().adicionarObservador(usuario, livro);
    }
}
