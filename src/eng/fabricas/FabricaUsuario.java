package eng.fabricas;

import eng.usuario.AlunoGraduacao;
import eng.usuario.AlunoPosGraduacao;
import eng.usuario.Professor;
import eng.usuario.Usuario;

public class FabricaUsuario {
    public Usuario criarUsuario(String codigo, String nome, TipoUsuario tipoUsuario) {
        return switch (tipoUsuario) {
            case ALUNO_GRADUACAO -> new AlunoGraduacao(codigo, nome);
            case ALUNO_POS_GRADUACAO -> new AlunoPosGraduacao(codigo, nome);
            case PROFESSOR -> new Professor(codigo, nome);
        };
    }
}
