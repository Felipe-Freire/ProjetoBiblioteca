package eng.transacoes;

import eng.itens.Livro;
import eng.usuario.Usuario;

import java.time.LocalDate;

public class Reserva extends Transacao{
    private final LocalDate dataReserva;

    public Reserva(Usuario usuario, Livro livro) {
        super(usuario, livro);
        this.dataReserva = LocalDate.now();
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }
}
