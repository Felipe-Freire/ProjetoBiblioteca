package eng.controle;

import eng.exceptions.ErroDeNegocio;
import eng.itens.Livro;
import eng.transacoes.Emprestimo;
import eng.transacoes.Reserva;
import eng.usuario.IObservador;
import eng.usuario.Usuario;
import eng.verificacao.Verificador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema {
    private final HashMap<String, Livro> livros = new HashMap<>();
    private final HashMap<String, Usuario> usuarios = new HashMap<>();
    private final ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private final ArrayList<Reserva> reservas = new ArrayList<>();

    private Sistema() {}

    private static Sistema instance;

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    public void adicionarObservador(String codigoUsuario, String codigoLivro) throws ErroDeNegocio{
        Usuario usuario = pegarUsuarioPorCodigo(codigoUsuario);
        Livro livro = pegarLivroPorCodigo(codigoLivro);

        if (usuario instanceof IObservador) {
            livro.adicionarObservador((IObservador) usuario);
        } else {
            // Trate o caso em que o usuário não implementa a interface IObservador
            throw new ErroDeNegocio("O usuário não pode ser observador.");
        }

    }

    public void consultarLivro(String codigoLivro) throws ErroDeNegocio {
        Livro livro = pegarLivroPorCodigo(codigoLivro);

        if (livro != null) {
            System.out.println("Informações do Livro:");
            System.out.println("Título: " + livro.getTitulo());

            // (ii) Quantidade de reservas e detalhes das reservas
            int quantidadeReservas = livro.getQuantidadeReservas();
            System.out.println("Quantidade de Reservas: " + quantidadeReservas);

            if (quantidadeReservas > 0) {
                System.out.println("Detalhes das Reservas:");

                for (Reserva reserva : pegaReservasPorLivro(livro)) {
                    System.out.println("Nome do Usuário: " + reserva.getUsuario().getNome());
                }
            }

            // (iii) Detalhes dos exemplares
            System.out.println("Detalhes dos Exemplares:");

            for (Map.Entry<String, Emprestimo> entry : livro.getExemplares().entrySet()) {
                String codigoExemplar = entry.getKey();
                Emprestimo emprestimo = entry.getValue();

                System.out.println("Código do Exemplar: " + codigoExemplar);

                if (emprestimo != null) {
                    System.out.println("Status: Emprestado");
                    System.out.println("Usuário do Empréstimo: " + emprestimo.getUsuario().getNome());
                    System.out.println("Data de Empréstimo: " + emprestimo.getDataAlugado());
                    System.out.println("Data Prevista para Devolução: " + emprestimo.getDataDevolucao());
                } else {
                    System.out.println("Status: Disponível");
                }
            }
        } else {
            throw new ErroDeNegocio("Livro não encontrado.");
        }
    }

    public void consultarUsuario(String codigoUsuario) {
        Usuario usuario = pegarUsuarioPorCodigo(codigoUsuario);

        if (usuario != null) {
            System.out.println("Lista de Empréstimos do Usuário:");
            for (Emprestimo emprestimo : pegaEmprestimosPorUsuario(usuario)) {
                System.out.println("Título do Livro: " + emprestimo.getLivro().getTitulo());
                System.out.println("Data do Empréstimo: " + emprestimo.getDataAlugado());
                System.out.println("Status do Empréstimo: " + (emprestimo.isFinalizado() ? "Finalizado" : "Em Curso"));

                if (emprestimo.isFinalizado()) {
                    System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
                }
            }

            System.out.println("Lista de Reservas do Usuário:");
            for (Reserva reserva : pegaReservasPorUsuario(usuario)) {
                System.out.println("Título do Livro Reservado: " + reserva.getLivro().getTitulo());
                System.out.println("Data da Solicitação da Reserva: " + reserva.getDataReserva());
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void consultarProfessor(String codigoUsuario) {
        Usuario usuario = pegarUsuarioPorCodigo(codigoUsuario);

        if (usuario instanceof IObservador) {
            int notificacoes = ((IObservador) usuario).getNotificacoes();

            System.out.println("Quantidade de Notificações para Reservas Simultâneas: " + notificacoes);
        } else {
            System.out.println("Não é professor.");
        }
    }

    public void devolverLivro(String codigoUsuario, String codigoLivro) throws ErroDeNegocio {
        Usuario usuario = pegarUsuarioPorCodigo(codigoUsuario);
        Livro livro = pegarLivroPorCodigo(codigoLivro);

        Emprestimo emprestimoEncontrado = null;

        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getUsuario().equals(usuario) && emprestimo.getLivro().equals(livro)) {
                emprestimoEncontrado = emprestimo;
                break;
            }
        }

        if (emprestimoEncontrado != null) {
            removeEmprestimo(emprestimoEncontrado);
            System.out.println("Devolução com sucesso para: Usuario - " + usuario.getNome() + " e Livro - " + livro.getTitulo());
        } else {
            throw new ErroDeNegocio("Erro: Empréstimo não encontrado para Usuario - " + usuario.getNome() + " e Livro - " + livro.getTitulo());
        }

    }

    public void emprestarLivro(String codigoUsuario, String codigoLivro) {
        Usuario usuario = pegarUsuarioPorCodigo(codigoUsuario);
        Livro livro = pegarLivroPorCodigo(codigoLivro);

        try {
            if (usuario.getEstrategiaEmprestimo().aplicarEstrategia(usuario, livro, this.reservas, this.emprestimos)) {

                for (Reserva reserva : this.reservas) {
                    if (reserva.getUsuario().equals(usuario) && reserva.getLivro().equals(livro)) {
                        removeReserva(reserva);
                        break;
                    }
                }

                adicionaEmprestimo(usuario, livro);

                System.out.println("Empréstimo com sucesso para: Usuario - " + usuario.getNome() + " e Livro - " + livro.getTitulo());
            } else {
                // Lógica para lidar com os diferentes tipos de erros de negócio
                System.out.println("Não foi possível realizar o empréstimo.");
            }

        } catch (ErroDeNegocio e) {
            // Lógica para tratar a exceção específica de negócio
            System.out.println(e.getMessage());
        }
    }

    public void reservarLivro(String codigoUsuario, String codigoLivro) throws ErroDeNegocio {
        Usuario usuario = pegarUsuarioPorCodigo(codigoUsuario);
        Livro livro = pegarLivroPorCodigo(codigoLivro);

        if (Verificador.verificaLiberdadeDeReserva(usuario)) {
            adicionaReserva(usuario, livro);
        } else {
            throw new ErroDeNegocio("Erro: Limite de reserva alcançado para Usuario - " + usuario.getNome() + " e Livro - " + livro.getTitulo());
        }
    }

    public void sairSistema() {
        System.out.println("Saindo do sistema...");

        // Encerre a execução do programa
        System.exit(0);
    }

    protected void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getCodigo(), usuario);
    }

    private Usuario pegarUsuarioPorCodigo(String codigo) {
        return usuarios.get(codigo);
    }

    protected void adicionarLivro(Livro livro) {
        livros.put(livro.getCodigo(), livro);
    }

    private Livro pegarLivroPorCodigo(String codigo) {
        return livros.get(codigo);
    }

    private void adicionaEmprestimo(Usuario usuario, Livro livro) {
        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        this.emprestimos.add(emprestimo);
        livro.realizaEmprestimo(emprestimo);
        usuario.emprestar();
    }

    private void removeEmprestimo(Emprestimo emprestimo) {
        emprestimo.setFinalizado(true);
        emprestimo.setDataEntregue(LocalDate.now());
        emprestimo.getLivro().removerEmprestimo(emprestimo);
        emprestimo.getUsuario().removeEmprestimo();
    }

    private void adicionaReserva(Usuario usuario, Livro livro) {
        Reserva reserva = new Reserva(usuario, livro);
        this.reservas.add(reserva);
        livro.reservar();
        usuario.reservar();
    }

    private void removeReserva(Reserva reserva) {
        this.reservas.remove(reserva);
        reserva.getLivro().removerReserva();
        reserva.getUsuario().removeReserva();
    }

    private ArrayList<Emprestimo> pegaEmprestimosPorLivro(Livro livro) {
        ArrayList<Emprestimo> emprestimosDoLivro = new ArrayList<>();
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getLivro().getCodigo().equals(livro.getCodigo())) {
                emprestimosDoLivro.add(emprestimo);
            }
        }
        return emprestimosDoLivro;
    }

    private ArrayList<Reserva> pegaReservasPorLivro(Livro livro) {
        ArrayList<Reserva> reservasDoLivro = new ArrayList<>();
        for (Reserva reserva : this.reservas) {
            if (reserva.getLivro().getCodigo().equals(livro.getCodigo())) {
                reservasDoLivro.add(reserva);
            }
        }
        return reservasDoLivro;
    }

    private ArrayList<Emprestimo> pegaEmprestimosPorUsuario(Usuario usuario) {
        ArrayList<Emprestimo> emprestimosDoLivro = new ArrayList<>();
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getUsuario().getCodigo().equals(usuario.getCodigo())) {
                emprestimosDoLivro.add(emprestimo);
            }
        }
        return emprestimosDoLivro;
    }

    private ArrayList<Reserva> pegaReservasPorUsuario(Usuario usuario) {
        ArrayList<Reserva> reservasDoLivro = new ArrayList<>();
        for (Reserva reserva : this.reservas) {
            if (reserva.getUsuario().getCodigo().equals(usuario.getCodigo())) {
                reservasDoLivro.add(reserva);
            }
        }
        return reservasDoLivro;
    }
}
