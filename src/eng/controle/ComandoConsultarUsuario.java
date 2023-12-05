package eng.controle;

public class ComandoConsultarUsuario implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];

        Sistema.getInstance().consultarUsuario(codigoUsuario);
    }
}
