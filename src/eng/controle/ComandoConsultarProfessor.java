package eng.controle;

import eng.exceptions.ErroDeNegocio;

public class ComandoConsultarProfessor implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoUsuario = parametros[0];

        try{
            Sistema.getInstance().consultarProfessor(codigoUsuario);
        } catch (ErroDeNegocio e) {
            System.out.println(e.getMessage());
        }
    }
}
