package eng.controle;

import eng.usuario.IObservador;
import eng.usuario.Usuario;

public class ComandoConsultarProfessor implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];

        Sistema.getInstance().consultarProfessor(codigoUsuario);
    }
}
