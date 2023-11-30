package br.ufba.eng;

import br.ufba.eng.controle.Comando;
import br.ufba.eng.controle.ISistema;
import br.ufba.eng.controle.Sistema;

public class Biblioteca {
    public static void main(String[] args) {
        Comando comando = new Comando();
        ISistema sistema = Sistema.getInstance();
    }
}
