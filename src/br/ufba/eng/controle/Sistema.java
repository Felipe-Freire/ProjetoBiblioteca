package br.ufba.eng.controle;

import br.ufba.eng.itens.Item;
import br.ufba.eng.transacoes.Emprestimo;
import br.ufba.eng.transacoes.Reserva;
import br.ufba.eng.usuario.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class Sistema implements ISistema{
    private final HashMap<String, Item> itens = new HashMap<>();
    private final HashMap<String, Usuario> usuarios = new HashMap<>();
    private final ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private final ArrayList<Reserva> reservas = new ArrayList<>();

//    private Sistema() {}
//
//    private static Sistema instance;
//
//    public static Sistema getInstance() {
//        if (instance == null){
//            instance = new Sistema();
//        }
//        return instance;
//    }

    @Override
    public void adicionarUsuario(Usuario usuario) {

    }

    @Override
    public Usuario pegarUsuarioPorId(String id) {
        return null;
    }

    @Override
    public void adicionarItem(Item item) {

    }

    @Override
    public Item pegarItemPorId(String id) {
        return null;
    }

    @Override
    public Emprestimo adicionaEmprestimo(Usuario usuario, Item item) {
        return null;
    }

    @Override
    public void removeEmprestimo(Usuario usuario, Item item) {

    }

    @Override
    public Reserva adicionaReserva(Usuario usuario, Item item) {
        return null;
    }

    @Override
    public ArrayList<Emprestimo> pegaEmprestimosIdOBjeto(String id) {
        return null;
    }

    @Override
    public ArrayList<Reserva> pegaReservaIdObjeto(String id) {
        return null;
    }
}
