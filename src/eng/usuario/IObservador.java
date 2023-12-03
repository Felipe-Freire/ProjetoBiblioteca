package eng.usuario;

import eng.itens.IObservavel;

public interface IObservador {
    public void observa(IObservavel observavel);
    public void removeObservador(IObservavel observavel);
    public void notificaObservador(IObservavel observavel);
    public int getNotificacoes();
}
