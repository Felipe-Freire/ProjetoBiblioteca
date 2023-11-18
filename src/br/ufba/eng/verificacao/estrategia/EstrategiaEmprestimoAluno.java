package br.ufba.eng.verificacao.estrategia;

import br.ufba.eng.itens.ILivro;
import br.ufba.eng.usuario.Usuario;

public class EstrategiaEmprestimoAluno implements IEstrategiaEmprestimo{
    @Override
    public boolean aplicarEstrategia(Usuario usuario, ILivro livro) {
        return false;
    }
}
