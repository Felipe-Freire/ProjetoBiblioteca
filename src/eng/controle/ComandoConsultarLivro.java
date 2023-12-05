package eng.controle;

import eng.exceptions.ErroDeNegocio;

public class ComandoConsultarLivro implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoLivro = parametros[0];

        try{
            Sistema.getInstance().consultarLivro(codigoLivro);
        } catch (ErroDeNegocio e) {
            System.out.println(e.getMessage());
        }
    }
}
