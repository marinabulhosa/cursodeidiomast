package model;

import java.time.LocalDate;
import java.util.List;

/*** Representa uma turma do curso.*/
public class Turma {
    private int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String lingua;
    private String nivel; // iniciante, intermediario, avancado
    private double preco;
    private List<Aluno> alunos;

    public Turma(int id, LocalDate dataInicio, LocalDate dataFim, String lingua, String nivel, double preco, List<Aluno> alunos) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.lingua = lingua;
        this.nivel = nivel;
        this.preco = preco;
        this.alunos = alunos;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public String getLingua() {
        return lingua;
    }

    public String getNivel() {
        return nivel;
    }

    public double getPreco() {
        return preco;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Turma " + id + " - " + lingua + " (" + nivel + ")";
    }
}