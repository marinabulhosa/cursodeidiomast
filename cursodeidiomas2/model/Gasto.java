package model;

import java.time.LocalDate;

/*** Representa um gasto da escola (material, contas, etc).*/
public class Gasto {
    private int id;
    private String descricao;
    private double valor;
    private LocalDate data;

    public Gasto(int id, String descricao, double valor, LocalDate data) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return data + " - " + descricao + ": R$ " + valor;
    }
}