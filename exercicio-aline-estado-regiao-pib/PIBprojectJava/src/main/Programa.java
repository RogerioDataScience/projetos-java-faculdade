package main;
import java.io.IOException;
import java.util.Locale;

public class Programa {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        // EX A
        String path = "C:\\Users\\x209499\\Documents\\pib.txt";
        ManutencaoArquivo.salvarEstadoLista(path);
        Estado.porcentualEstado();
        ManutencaoArquivo.imprimirDadosEstadoConsole();

        System.out.println("**Valores dos PIB's com aproximação de duas casas decimais.");


        // EX B
        path = "C:\\Users\\x209499\\Documents\\regioes.txt";
        ManutencaoArquivo.salvarRegiaoLista(path);
        Regiao.somarPIBTotalPorRegiao();
        path = "C:\\Users\\x209499\\Documents\\saida.txt";
        ManutencaoArquivo.gerarArquivoSaida(path);
        System.out.println("\nFim!");
    }
}
