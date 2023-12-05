package eng.itens;

import eng.transacoes.Emprestimo;
import eng.usuario.IObservador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private HashMap<String, Emprestimo> exemplares;

    public Livro(String codigo, String titulo, String editora, ArrayList<String> autores, int edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = 0;
        this.quantidadeTotal = 0;
        this.quantidadeReservas = 0;
        this.observadores = new ArrayList<>();
        this.exemplares = new HashMap<>();
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

    public int getQuantidadeTotal() {
        return quantidadeTotal;
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

    public HashMap<String, Emprestimo> getExemplares() {
        return this.exemplares;
    }

    public void adicionarExemplar(String codigo) {
        // Verifica se o exemplar já existe no HashMap
        if (!this.exemplares.containsKey(codigo)) {
            // Se não existir, adiciona o exemplar com um valor inicial null
            this.exemplares.put(codigo, null);
            this.quantidadeTotal++;
            this.quantidadeDisponivel++;
        } else {
            System.out.println("Exemplar já existe: " + codigo);
        }
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
    public void realizaEmprestimo(Emprestimo emprestimo) {
        setQuantidadeDisponivel(getQuantidadeTotal() - 1);
        for (Map.Entry<String, Emprestimo> entry : exemplares.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue(emprestimo);
                return;  // Adicionou o empréstimo, então saia do método
            }
        }
    }

    @Override
    public void removerEmprestimo(Emprestimo emprestimo) {
        setQuantidadeDisponivel(getQuantidadeDisponivel() + 1);
        // Apenas desvincule o primeiro empréstimo encontrado
        exemplares.entrySet().stream().filter(entry -> entry.getValue() == emprestimo).findFirst().ifPresent(entry -> entry.setValue(null));
    }
}
