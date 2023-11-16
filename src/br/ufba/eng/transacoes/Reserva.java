package br.ufba.eng.transacoes;

import br.ufba.eng.livro.IDados;
import br.ufba.eng.usuario.Usuario;

import java.time.LocalDate;

public class Reserva extends Transacao{
    private LocalDate dataReserva;

    public Reserva(Usuario usuario, IDados livro) {
        super(usuario, livro);
        this.dataReserva = LocalDate.now();
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }
}
