package eng.controle;

import eng.exceptions.ErroDeNegocio;

public class ComandoEmprestarLivro implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];
        String codigoLivro = parametros[1];

        try {
            Sistema.getInstance().emprestarLivro(codigoUsuario, codigoLivro);
        } catch (ErroDeNegocio e) {
            System.out.println(e.getMessage());
        }
    }
}
