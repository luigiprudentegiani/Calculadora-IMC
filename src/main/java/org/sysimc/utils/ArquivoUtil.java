package org.sysimc.utils;

import org.sysimc.model.Pessoa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {

    private static final String CAMINHO_ARQUIVO = "dados_pessoas.txt";

    public static void salvarPessoas(List<Pessoa> pessoas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Pessoa p : pessoas) {

                String linha = p.getNome() + "," + p.getAltura() + "," + p.getPeso() + "," + p.getImc();
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Dados salvos com sucesso em " + CAMINHO_ARQUIVO);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public static List<Pessoa> carregarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        File arquivo = new File(CAMINHO_ARQUIVO);

        if (!arquivo.exists()) {
            return pessoas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(",");

                if (dados.length >= 3) {
                    String nome = dados[0];
                    float altura = Float.parseFloat(dados[1]);
                    float peso = Float.parseFloat(dados[2]);

                    float imc = (dados.length >= 4) ? Float.parseFloat(dados[3]) : 0f;

                    Pessoa p = new Pessoa(nome, altura, peso, imc);

                    pessoas.add(p);
                }
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao ler ou converter os dados do arquivo: " + e.getMessage());
        }

        return pessoas;
    }
}