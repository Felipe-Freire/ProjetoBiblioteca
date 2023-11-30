package br.ufba.eng.itens;

import br.ufba.eng.usuario.IObservador;

import java.util.ArrayList;
import java.util.List;

public class Livro implements IObservavel, IReservavel, IEmprestavel {
    private final String codigo;
    private final String titulo;
    private final int anoPublicacao;
    private int quantidadeDisponivel;
    private int quantidadeTotal;
    private final String editora;
    private final ArrayList<String> autores;
    private final int edicao;
    private int quantidadeReservas;
    private List<IObservador> observadores;

    public Livro(String codigo, String titulo, String editora, ArrayList<String> autores, int edicao, int anoPublicacao, int quantidadeTotal) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeTotal;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeReservas = 0;
        this.observadores = new ArrayList<IObservador>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public String getEditora() {
        return editora;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public void setQuantidadeReservas(int quantidadeReservas) {
        this.quantidadeReservas = quantidadeReservas;
    }

    @Override
    public List<IObservador> getObservadores() {
        return observadores;
    }

    @Override
    public void setObservadores(List<IObservador> observadores) {
        this.observadores = observadores;
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
        if (getQuantidadeTotal() > 0) {
            setQuantidadeTotal(getQuantidadeTotal() - 1);
            return true;
        }
        return false;
    }

    @Override
    public void removerEmprestimo() {
        if (getQuantidadeDisponivel() < getQuantidadeTotal()) {
            setQuantidadeDisponivel(getQuantidadeDisponivel() + 1);
        }
    }
}
