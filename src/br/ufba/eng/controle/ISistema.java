package br.ufba.eng.controle;

import br.ufba.eng.itens.Item;
import br.ufba.eng.transacoes.Emprestimo;
import br.ufba.eng.transacoes.Reserva;
import br.ufba.eng.usuario.Usuario;

import java.util.ArrayList;

public interface ISistema {
    public void adicionarUsuario(Usuario usuario);

    public Usuario pegarUsuarioPorId(String id);

    public void adicionarItem(Item item);

    public Item pegarItemPorId(String id);

    public Emprestimo adicionaEmprestimo(Usuario usuario, Item item);

    public void removeEmprestimo(Usuario usuario, Item item);

    public Reserva adicionaReserva(Usuario usuario, Item item);

    public ArrayList<Emprestimo> pegaEmprestimosIdOBjeto(String id);

    public ArrayList<Reserva> pegaReservaIdObjeto(String id);

}
