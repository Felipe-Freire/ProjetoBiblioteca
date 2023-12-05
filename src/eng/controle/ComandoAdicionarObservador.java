package eng.controle;

import eng.exceptions.ErroDeNegocio;
import eng.itens.Livro;
import eng.usuario.Usuario;

public class ComandoAdicionarObservador implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];
        String codigoLivro = parametros[1];

        try{
            Sistema.getInstance().adicionarObservador(codigoUsuario, codigoLivro);
        } catch (ErroDeNegocio e) {
            System.out.println(e.getMessage());
        }
    }
}
