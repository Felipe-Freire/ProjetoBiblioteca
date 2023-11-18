package br.ufba.eng.itens;

import br.ufba.eng.usuario.IObservador;

public interface IObservavel {
    public void adicionarObservador(IObservador observador);
    public void removerObservador(IObservador iObservador);
    public void notificarObservadores();
}
