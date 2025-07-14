package model;

/**
 * Representa a nota de um aluno em uma turma.
 */
public class Nota {
    private Aluno aluno;
    private Turma turma;
    private double valor;

    public Nota(Aluno aluno, Turma turma, double valor) {
        this.aluno = aluno;
        this.turma = turma;
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return aluno.getNome() + ": " + valor;
    }
}