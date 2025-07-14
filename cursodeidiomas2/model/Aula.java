package model;

import java.time.LocalDate;
import java.time.LocalTime;

/*** Representa uma aula pertencente a uma turma.*/
public class Aula {
    private int id;
    private Turma turma;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Professor professor;

    public Aula(int id, Turma turma, LocalDate data, LocalTime horaInicio, LocalTime horaFim, Professor professor) {
        this.id = id;
        this.turma = turma;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public Turma getTurma() {
        return turma;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Aula " + id + " (" + data + ")";
    }
}