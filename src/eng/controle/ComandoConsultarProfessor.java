package eng.controle;

import eng.usuario.IObservador;
import eng.usuario.Usuario;

public class ComandoConsultarProfessor implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];

        Usuario usuario = Sistema.getInstance().pegarUsuarioPorCodigo(codigoUsuario);

        Sistema.getInstance().consultarProfessor((IObservador) usuario);
    }
}
