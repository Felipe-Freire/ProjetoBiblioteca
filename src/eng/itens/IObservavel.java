package eng.itens;

import eng.usuario.IObservador;

import java.util.List;

public interface IObservavel {
    void adicionarObservador(IObservador observador);
    void removerObservador(IObservador iObservador);
    void notificarObservadores();
    List<IObservador> getObservadores();
    void setObservadores(List<IObservador> observadores);
}
