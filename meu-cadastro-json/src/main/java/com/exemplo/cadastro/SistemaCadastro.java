package com.exemplo.cadastro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SistemaCadastro {
    private static final String PASTA = "src/main/resources/cadastros";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvarCadastro(Pessoa pessoa) {
        File pasta = new File(PASTA);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        int id = new File(PASTA).listFiles().length + 1;
        String nomeArquivo = PASTA + "/usuario" + id + ".json";

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            gson.toJson(pessoa, writer);
            System.out.println("✅ Cadastro salvo em " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listarCadastros() {
        File pasta = new File(PASTA);
        File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".json"));

        if (arquivos != null && arquivos.length > 0) {
            System.out.println("\n📂 Lista de cadastros:");
            for (File arquivo : arquivos) {
                System.out.println(" - " + arquivo.getName());
            }
        } else {
            System.out.println("Nenhum cadastro encontrado.");
        }
    }

    public static void buscarCadastro(String nomeArquivo) {
        File arquivo = new File(PASTA + "/" + nomeArquivo + ".json");

        if (arquivo.exists()) {
            try (FileReader reader = new FileReader(arquivo)) {
                Pessoa pessoa = gson.fromJson(reader, Pessoa.class);
                System.out.println("\n📌 Dados do cadastro:\n" + pessoa);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ Cadastro não encontrado.");
        }
    }
}
