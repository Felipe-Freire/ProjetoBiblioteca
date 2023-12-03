package eng.controle;

import eng.itens.Livro;
import eng.usuario.Usuario;

public class ComandoAdicionarObservador implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];
        String codigoLivro = parametros[1];

        Sistema.getInstance().adicionarObservador(codigoUsuario, codigoLivro);
    }
}
