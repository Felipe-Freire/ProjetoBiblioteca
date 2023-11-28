package br.ufba.eng.itens;

import java.util.ArrayList;

public interface ILivro extends IObservavel, IReservavel, IEmprestavel{
    public String getCodigo();

    public String getTitulo();

    public int getAnoPublicacao();

    public int getQuantidadeDisponivel();

    public void setQuantidadeDisponivel(int quantidadeDisponivel);

    public int getQuantidadeTotal();

    public void setQuantidadeTotal(int quantidadeTotal);

    public String getEditora();

    public ArrayList<String> getAutores();

    public int getEdicao();

}
