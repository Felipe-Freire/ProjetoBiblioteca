package eng.controle;

public class ComandoConsultarProfessor implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];

        Sistema.getInstance().consultarProfessor(codigoUsuario);
    }
}
