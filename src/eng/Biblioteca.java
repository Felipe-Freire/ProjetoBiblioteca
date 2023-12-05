package eng;

import eng.controle.CarregarDados;
import eng.controle.Comando;

public class Biblioteca {
    public static void main(String[] args) {
        CarregarDados.carregarDados();
        Comando comando = new Comando();
        comando.iniciarComandos();
        comando.executarComando();
    }
}
