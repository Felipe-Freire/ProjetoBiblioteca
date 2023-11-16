package br.ufba.eng.usuario;

import br.ufba.eng.livro.IObservavel;

public interface IObservador {
    public void observa(IObservavel observavel);
    public void removeObservador(IObservavel observavel);

}
