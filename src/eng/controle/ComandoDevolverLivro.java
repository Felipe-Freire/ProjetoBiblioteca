package eng.controle;

import eng.exceptions.ErroDeNegocio;
import eng.itens.Livro;
import eng.usuario.Usuario;
import eng.verificacao.Verificador;

public class ComandoDevolverLivro implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];
        String codigoLivro = parametros[0];

        try {
            Sistema.getInstance().devolverLivro(codigoUsuario, codigoLivro);
        } catch (ErroDeNegocio e) {
            System.out.println(e.getMessage());
        }
    }
}
