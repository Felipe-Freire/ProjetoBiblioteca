package eng.controle;

import eng.usuario.Usuario;

public class ComandoConsultarUsuario implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];

        Usuario usuario = Sistema.getInstance().pegarUsuarioPorCodigo(codigoUsuario);

        Sistema.getInstance().consultarUsuario(usuario);
    }
}
