package br.ufba.eng.usuario;

public class AlunoPosGraduacao extends Usuario{
    public AlunoPosGraduacao(String codigo, String nome) {
        super(codigo, nome);
        setTempoEmprestimo(4);
        setLimiteEmprestimo(4);
    }
}
