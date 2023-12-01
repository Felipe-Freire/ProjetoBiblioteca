package eng.usuario;

import eng.verificacao.EstrategiaEmprestimoAluno;

public class AlunoGraduacao extends Usuario{
    public AlunoGraduacao(String codigo, String nome) {
        super(codigo, nome);
        setTempoEmprestimo(3);
        setLimiteEmprestimo(3);
        estrategiaEmprestimo = new EstrategiaEmprestimoAluno();
    }
}
