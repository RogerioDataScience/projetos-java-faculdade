package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ManutencaoArquivo {

    public static void salvarEstadoLista(String path) {
        try {
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {
                String[] dadosSplit = linha.split(";");
                String nome = dadosSplit[0];
                String valorPIBstr = dadosSplit[1];
                Double valorPIB = Double.parseDouble(valorPIBstr);
                Estado.listaEstado.add(new Estado(nome, valorPIB, 0.0));
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }

    public static void salvarRegiaoLista(String path) {
        try {
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            String nome = linha;
            List<String> arrayArquivoRegioes = new ArrayList<>();
            int i = 0;
            while (linha != null) {
                if (linha.equals("")) {
                    Regiao.listaRegiao.add(new Regiao(nome, arrayArquivoRegioes, 0.0));
                    linha = lerArq.readLine();
                    nome = linha;
                    i = 0;
                    arrayArquivoRegioes = new ArrayList<>();
                } else {
                    linha = lerArq.readLine();
                    // o erro está aqui!!
                    if (linha == null) {
                        Regiao.listaRegiao.add(new Regiao(nome, arrayArquivoRegioes, 0.0));
                    } else if (linha.equals("")) {
                        ;
                    } else {
                        arrayArquivoRegioes.add(linha);
                    }
                }
                i++;
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }

    public static void gerarArquivoSaida(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        for (Regiao regiao : Regiao.listaRegiao) {
            buffWrite.append(regiao.toString());
            buffWrite.append("\n");
        }
        buffWrite.close();
        System.out.println("\n**Arquivo de saída gerado com sucesso! Caminho: " + path);
    }

    public static void imprimirDadosEstadoConsole() {
        for (Estado estado : Estado.listaEstado) {
            System.out.println(estado);
        }
    }

}
