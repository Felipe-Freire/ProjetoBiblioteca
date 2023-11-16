package br.ufba.eng.livro;

import java.util.List;

public interface IDados {
    String getCodigo();

    String getTitulo();

    String getEditora();

    List<String> getAutores();

    int getEdicao();

    int getAnoPublicacao();

    public int getQuantidadeDisponivel();
}
