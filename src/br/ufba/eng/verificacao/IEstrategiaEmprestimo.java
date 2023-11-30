package br.ufba.eng.verificacao;

import br.ufba.eng.itens.Livro;
import br.ufba.eng.usuario.Usuario;

public interface IEstrategiaEmprestimo {
    public boolean aplicarEstrategia(Usuario usuario, Livro livro);
}
