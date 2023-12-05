package eng.controle;

public class ComandoEmprestarLivro implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];
        String codigoLivro = parametros[1];

        Sistema.getInstance().emprestarLivro(codigoUsuario, codigoLivro);
    }
}
