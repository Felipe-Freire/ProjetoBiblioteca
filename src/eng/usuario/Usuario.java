package eng.usuario;

import eng.verificacao.IEstrategiaEmprestimo;

public abstract class Usuario {
    private final String codigo;
    private final String nome;
    private int quantLivrosReservados;
    private int quantLivrosEmprestados;
    private final int limiteReservas;
    private int limiteEmprestimo;
    private int tempoEmprestimo;
    private boolean passeLivreEmprestimo;
    protected IEstrategiaEmprestimo estrategiaEmprestimo;

    public Usuario(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantLivrosReservados = 0;
        this.quantLivrosEmprestados = 0;
        this.limiteReservas = 3;
        this.limiteEmprestimo = -1;
        this.tempoEmprestimo = 7;
        this.passeLivreEmprestimo = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantLivrosReservados() {
        return quantLivrosReservados;
    }

    public int getLimiteReservas() {
        return limiteReservas;
    }

    public void removeReserva() {
        this.quantLivrosReservados--;
    }

    public void reservar() {
        this.quantLivrosReservados++;
    }

    public int getQuantLivrosEmprestados() {
        return quantLivrosEmprestados;
    }

    public void removeEmprestimo() {
        this.quantLivrosEmprestados--;
    }

    public void emprestar() {
        this.quantLivrosEmprestados++;
    }

    public int getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(int limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public int getTempoEmprestimo() {
        return tempoEmprestimo;
    }

    public void setTempoEmprestimo(int tempoEmprestimo) {
        this.tempoEmprestimo = tempoEmprestimo;
    }

    public boolean isPasseLivreEmprestimo() {
        return passeLivreEmprestimo;
    }

    public void setPasseLivreEmprestimo(boolean passeLivreEmprestimo) {
        this.passeLivreEmprestimo = passeLivreEmprestimo;
    }

    public IEstrategiaEmprestimo getEstrategiaEmprestimo() {
        return estrategiaEmprestimo;
    }

    public void setEstrategiaEmprestimo(IEstrategiaEmprestimo estrategiaEmprestimo) {
        this.estrategiaEmprestimo = estrategiaEmprestimo;
    }
}
