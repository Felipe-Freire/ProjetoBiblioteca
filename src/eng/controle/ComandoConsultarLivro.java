package eng.controle;

import eng.itens.Livro;

public class ComandoConsultarLivro implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoLivro = parametros[0];

        Sistema.getInstance().consultarLivro(codigoLivro);
    }
}
