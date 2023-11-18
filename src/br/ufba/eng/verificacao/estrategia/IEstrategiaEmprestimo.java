package br.ufba.eng.verificacao.estrategia;

import br.ufba.eng.itens.ILivro;
import br.ufba.eng.usuario.Usuario;

public interface IEstrategiaEmprestimo {
    public boolean aplicarEstrategia(Usuario usuario, ILivro livro);
}
