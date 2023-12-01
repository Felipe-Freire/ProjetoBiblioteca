package eng.controle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Comando {
    private final Map<String, IComando> comandos = new HashMap<String, IComando>();

    public Comando(){
        iniciarComandos();
    }

    public void iniciarComandos(){
        this.comandos.put("emp", new ComandoEmprestarLivro());
        this.comandos.put("dev", new ComandoDevolverLivro());
        this.comandos.put("res", new ComandoReservarLivro());
        this.comandos.put("obs", new ComandoAdicionarObservador());
        this.comandos.put("liv", new ComandoConsultarLivro());
        this.comandos.put("usu", new ComandoConsultarUsuario());
        this.comandos.put("ntf", new ComandoConsultarProfessor());
        this.comandos.put("sai", new ComandoSairSistema());
    }

    public void executarComando(){
        Scanner teclado = new Scanner(System.in);
        String entrada;
        String comando;
        String parametros;

        entrada = teclado.nextLine();

        comando = entrada.substring(0, 3);
        try {
            parametros = entrada.substring(4);
        } catch (Exception e) {
            parametros = "vazio";
        }

        IComando c = comandos.get(comando);
        c.executar(parametros);
        System.out.println("");

    }

    public static void imprimirMensagem(String msg){
        System.out.println(msg);
    }
}
