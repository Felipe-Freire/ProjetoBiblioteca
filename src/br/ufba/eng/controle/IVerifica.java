package br.ufba.eng.controle;

import br.ufba.eng.itens.ILivro;
import br.ufba.eng.usuario.Usuario;

public interface IVerifica {
    boolean verificaReserva(Usuario usuario, ILivro livro);

    boolean verificaQuantidadeDeEmprestimo(Usuario usuario);

    boolean verificaEstadoDevedor(Usuario usuario, ILivro livro);

    boolean verificaEmprestimo(Usuario usuario, ILivro livro);
}
