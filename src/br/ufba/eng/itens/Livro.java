package br.ufba.eng.itens;

import br.ufba.eng.usuario.IObservador;

import java.util.ArrayList;
import java.util.List;

public class Livro extends Item implements ILivro {
    private final String editora;
    private final ArrayList<String> autores;
    private final int edicao;
    private int quantidadeReservas;
    private List<IObservador> observadores;

    public Livro(String codigo, String titulo, String editora, ArrayList<String> autores, int edicao, int anoPublicacao, int quantidadeTotal) {
        super(codigo, titulo, anoPublicacao, quantidadeTotal);
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.quantidadeReservas = 0;
        this.observadores = new ArrayList<>();
    }

    @Override
    public void reservar() {
        quantidadeReservas++;
        if (quantidadeReservas >= 2) {
            notificarObservadores();
        }
    }

    @Override
    public void removerReserva() {
        quantidadeReservas--;
        if (quantidadeReservas >= 2) {
            notificarObservadores();
        }
    }

    public int getQuantidadeReservas() {
        return quantidadeReservas;
    }

    @Override
    public void adicionarObservador(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (IObservador observador : observadores) {
            observador.observa(this);
        }
    }

    @Override
    public boolean realizaEmprestimo() {
        return false;
    }

    @Override
    public void removerEmprestimo() {

    }
}
