package eng.usuario;

import eng.itens.IObservavel;
import eng.verificacao.EstrategiaEmprestimoProfessor;

public class Professor extends Usuario implements IObservador{
    private int notificacoes;

    public Professor(String codigo, String nome) {
        super(codigo, nome);
        setPasseLivreEmprestimo(true);
        this.notificacoes = 0;
        estrategiaEmprestimo = new EstrategiaEmprestimoProfessor();
    }

    @Override
    public void observa(IObservavel observavel) {
        observavel.adicionarObservador(this);
    }

    @Override
    public void removeObservador(IObservavel observavel) {
        observavel.removerObservador(this);
    }

    @Override
    public void notificaObservador(IObservavel observavel) {
        notificacoes++;
    }


}
