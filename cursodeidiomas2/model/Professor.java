package model;

import java.util.List;

/**
 * Representa um professor do curso.
 */
public class Professor {
    private String matricula;
    private String nome;
    private String endereco;
    private String telefone;
    private double valorHora;
    private List<String> linguas; // Inglês, Francês, Espanhol etc.

    public Professor(String matricula, String nome, String endereco, String telefone, double valorHora, List<String> linguas) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.valorHora = valorHora;
        this.linguas = linguas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public List<String> getLinguas() {
        return linguas;
    }

    public void setLinguas(List<String> linguas) {
        this.linguas = linguas;
    }

    @Override
    public String toString() {
        return nome + " (" + matricula + ")";
    }
}