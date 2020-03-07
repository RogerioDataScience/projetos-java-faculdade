package main;

import java.util.ArrayList;
import java.util.List;


public class Estado {
    private String nome;
    private Double valorPIB;
    private Double porcentual;

    public static List<Estado> listaEstado = new ArrayList<>();

    public Estado() {
    }

    public Estado(String nome, Double valorPIB, Double porcentual) {
        this.nome = nome;
        this.valorPIB = valorPIB;
        this.porcentual = porcentual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorPIB() {
        return valorPIB;
    }

    public void setValorPIB(Double valorPIB) {
        this.valorPIB = valorPIB;
    }

    public Double getPorcentual() {
        return porcentual;
    }

    public void setPorcentual(Double porcentual) {
        this.porcentual = porcentual;
    }

    public static void porcentualEstado() {
        double valorPIBtotal = 0;
        for (Estado estado : listaEstado) {
            valorPIBtotal += estado.getValorPIB();
        }
        System.out.println("Valor total pib: " + valorPIBtotal);
        for (Estado estado : listaEstado) {
            Double porcentual = (estado.getValorPIB() * 100) / valorPIBtotal;
            estado.setPorcentual(porcentual);
        }
    }

    public String toString() {
        return nome + " - PIB: " + String.format("%.2f", valorPIB) + " - " + String.format("%.2f", porcentual) + "%";
    }

}
