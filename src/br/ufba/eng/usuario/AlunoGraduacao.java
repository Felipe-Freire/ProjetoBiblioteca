package br.ufba.eng.usuario;

public class AlunoGraduacao extends Usuario{
    public AlunoGraduacao(String codigo, String nome) {
        super(codigo, nome);
        setTempoEmprestimo(3);
        setLimiteEmprestimo(3);
    }
}
