package br.ufba.eng.livro;

import java.util.List;

public class Livro implements ILivro {
    private final String codigo;
    private final String titulo;
    private final String editora;
    private final List<String> autores;
    private final int edicao;
    private final int anoPublicacao;
    private int quantidadeDisponivel;
    private int quantidadeTotal;
    private int quantidadeReservas;

    public Livro(String codigo, String titulo, String editora, List<String> autores, int edicao, int anoPublicacao, int quantidadeTotal) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeTotal;
        this.quantidadeReservas = 0;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getEditora() {
        return editora;
    }

    @Override
    public List<String> getAutores() {
        return autores;
    }

    @Override
    public int getEdicao() {
        return edicao;
    }

    @Override
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    @Override
    public void reservar() {

    }

    @Override
    public void removerReserva() {

    }

    public int getQuantidadeReservas() {
        return quantidadeReservas;
    }

    @Override
    public void adicionarObservador() {

    }

    @Override
    public void removerObservador() {

    }

    @Override
    public boolean realizaEmprestimo() {
        return false;
    }

    @Override
    public void removerEmprestimo() {

    }
}
