package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Extrato {

    private List<String> historicos = new ArrayList<>();
    private String path = System.getProperty("user.home") + "\\Downloads\\extrato.txt";

    public void addTransacao(String transacao) {
        historicos.add(transacao);
    }

    public void gerarExtrato() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String linha : historicos) {
                bw.write(linha);
                bw.newLine();
            }
            System.out.println("Extrato gerado com sucesso em: " + path);
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo de extrato: " + e.getMessage());
        }
    }

}
