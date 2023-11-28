package br.ufba.eng.usuario;

import br.ufba.eng.verificacao.EstrategiaEmprestimoAluno;

public class AlunoPosGraduacao extends Usuario{
    public AlunoPosGraduacao(String codigo, String nome) {
        super(codigo, nome);
        setTempoEmprestimo(4);
        setLimiteEmprestimo(4);
        estrategiaEmprestimo = new EstrategiaEmprestimoAluno();
    }
}
