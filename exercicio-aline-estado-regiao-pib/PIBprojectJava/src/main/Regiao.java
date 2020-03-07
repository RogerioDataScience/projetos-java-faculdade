package main;

import java.util.ArrayList;
import java.util.List;

public class Regiao {
    private String nome;
    private List<String> arrayEstado = new ArrayList<>();
    private Double somaTotal;
    public static List<Regiao> listaRegiao = new ArrayList<>();

    public Regiao(String nome, List<String> arrayEstado, double somaTotal) {
        this.nome = nome;
        this.arrayEstado = arrayEstado;
        this.somaTotal = somaTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getArrayEstado() {
        return arrayEstado;
    }

    public void setArrayEstado(List<String> arrayEstado) {
        this.arrayEstado = arrayEstado;
    }

    public Double getSomaTotal() {
        return somaTotal;
    }

    public void setSomaTotal(Double somaTotal) {
        this.somaTotal = somaTotal;
    }

    public static void somarPIBTotalPorRegiao() {
        double somaTemp = 0;
        int qtdEstadosCount = 0;
        int qtdEstadosCount1 = 1;
        int indice = 0;
        for (Regiao regiao : listaRegiao) {
            int qtdEstadosPorRegiao = regiao.arrayEstado.size();
            qtdEstadosCount = 0;
            //variavel abaixo criada para coincidir com o size do arrayEstado, na linha 68.
            qtdEstadosCount1 = 1;
            while (qtdEstadosCount1 < qtdEstadosPorRegiao) {
                if (regiao.arrayEstado.get(qtdEstadosCount) != null) {
                    String estadoStr = regiao.arrayEstado.get(qtdEstadosCount);
                    while (indice < qtdEstadosPorRegiao) {
                        if (!estadoStr.equals("")) {
                            for (Estado estado : Estado.listaEstado) {
                                if (estadoStr.equals(estado.getNome())) {
                                    somaTemp = somaTemp + estado.getValorPIB();
                                    if (qtdEstadosCount1 < qtdEstadosPorRegiao) {
                                        qtdEstadosCount++;
                                        qtdEstadosCount1++;
                                    }
                                    estadoStr = regiao.arrayEstado.get(qtdEstadosCount);
                                    indice++;
                                }
                            }
                        } else {
                            indice++;
                        }
                    }
                    regiao.setSomaTotal(somaTemp);
                    somaTemp = 0;
                    indice = 0;
                } else {
                    qtdEstadosCount++;
                    qtdEstadosCount1++;
                }
            }
        }
    }

    public String toString() {
        return nome + " -> " + String.format("%.2f", somaTotal)
                + "\n"
                + arrayEstado
                + "\n";
    }


}
