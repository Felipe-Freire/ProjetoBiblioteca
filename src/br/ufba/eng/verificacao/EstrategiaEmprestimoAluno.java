package br.ufba.eng.verificacao;

import br.ufba.eng.itens.Livro;
import br.ufba.eng.usuario.Usuario;

public class EstrategiaEmprestimoAluno implements IEstrategiaEmprestimo{
    @Override
    public boolean aplicarEstrategia(Usuario usuario, Livro livro) {
        return false;
    }
}
