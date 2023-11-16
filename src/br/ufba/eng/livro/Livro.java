package br.ufba.eng.livro;

import java.util.List;

public class Livro implements IObservavel{
    private final String codigo;
    private final String titulo;
    private String editora;
    private List<String> autores;
    private int edicao;
    private int anoPublicacao;
    private int quantidadeDisponivel;
    private int quantidadeReservas;

    public Livro(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public Livro(String codigo, String titulo, String editora, List<String> autores, int edicao, int anoPublicacao) {
        this(codigo, titulo);
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getQuantidadeReservas() {
        return quantidadeReservas;
    }

    public void setQuantidadeReservas(int quantidadeReservas) {
        this.quantidadeReservas = quantidadeReservas;
    }

    @Override
    public void adicionarObservador() {

    }

    @Override
    public void removerObservador() {

    }

    @Override
    public void notificarObservadores() {

    }
}
