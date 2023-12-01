package eng.controle;

import eng.itens.Livro;
import eng.usuario.Usuario;
import eng.verificacao.Verificador;

public class ComandoDevolverLivro implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];
        String codigoLivro = parametros[0];

        Usuario usuario = Sistema.getInstance().pegarUsuarioPorCodigo(codigoUsuario);
        Livro livro = Sistema.getInstance().pegarLivroPorCodigo(codigoLivro);

        if (Verificador.verificaUsuarioELivro(usuario, livro)){
            Sistema.getInstance().devolverLivro(usuario, livro);
        }
    }
}
