package br.ufba.eng.fabricas;

import br.ufba.eng.usuario.AlunoGraduacao;
import br.ufba.eng.usuario.AlunoPosGraduacao;
import br.ufba.eng.usuario.Professor;
import br.ufba.eng.usuario.Usuario;

public class FabricaUsuario {
    public Usuario criarUsuario(String codigo, String nome, TipoUsuario tipoUsuario) {
        return switch (tipoUsuario) {
            case ALUNO_GRADUACAO -> new AlunoGraduacao(codigo, nome);
            case ALUNO_POS_GRADUACAO -> new AlunoPosGraduacao(codigo, nome);
            case PROFESSOR -> new Professor(codigo, nome);
        };
    }
}
