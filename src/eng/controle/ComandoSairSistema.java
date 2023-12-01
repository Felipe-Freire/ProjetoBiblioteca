package eng.controle;

public class ComandoSairSistema implements IComando{
    @Override
    public void executar(String... parametros) {
        Sistema.getInstance().sairSistema();
    }
}
