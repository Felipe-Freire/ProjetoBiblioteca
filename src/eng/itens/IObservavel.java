package eng.itens;

import eng.usuario.IObservador;

import java.util.List;

public interface IObservavel {
    public void adicionarObservador(IObservador observador);
    public void removerObservador(IObservador iObservador);
    public void notificarObservadores();
    public List<IObservador> getObservadores();
    public void setObservadores(List<IObservador> observadores);
}
