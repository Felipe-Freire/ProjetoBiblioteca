package eng.controle;

import eng.itens.Livro;
import eng.usuario.Usuario;
import eng.verificacao.Verificador;

public class ComandoEmprestarLivro implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];
        String codigoLivro = parametros[0];

        Sistema.getInstance().emprestarLivro(codigoUsuario, codigoLivro);
    }
}
