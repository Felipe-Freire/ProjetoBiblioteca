package br.ufba.eng.usuario;

import br.ufba.eng.livro.IObservavel;

public class Professor extends Usuario implements IObservador{
    public Professor(String codigo, String nome) {
        super(codigo, nome);
        setPasseLivreEmprestimo(true);
    }

    @Override
    public void observa(IObservavel observavel) {

    }

    @Override
    public void removeObservador(IObservavel observavel) {

    }
}
