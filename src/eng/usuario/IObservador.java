package eng.usuario;

import eng.itens.IObservavel;

public interface IObservador {
    public void observa();
    public void removeObservador(IObservavel observavel);
    public int getNotificacoes();
}
