package br.ufba.eng.itens;

public abstract class Item {
    private final String codigo;
    private final String titulo;
    private final int anoPublicacao;
    private int quantidadeDisponivel;
    private int quantidadeTotal;

    public Item(String codigo, String titulo, int anoPublicacao, int quantidadeTotal) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeTotal;
        this.quantidadeTotal = quantidadeTotal;
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
}
