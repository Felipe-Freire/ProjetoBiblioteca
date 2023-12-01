package eng.controle;

import eng.itens.Livro;

public class ComandoConsultarLivro implements IComando{
    @Override
    public void executar(String... parametros) {
        String codigoLivro = parametros[0];

        Livro livro = Sistema.getInstance().pegarLivroPorCodigo(codigoLivro);

        Sistema.getInstance().consultarLivro(livro);
    }
}
