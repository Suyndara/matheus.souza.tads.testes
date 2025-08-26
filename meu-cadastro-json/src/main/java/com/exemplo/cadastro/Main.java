package com.exemplo.cadastro;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 - Cadastrar\n2 - Listar cadastros\n3 - Buscar cadastro\n4 - Sair");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": cadastrar(); break;
                case "2": SistemaCadastro.listarCadastros(); break;
                case "3": buscar(); break;
                case "4": return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrar() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, idade, email);
        SistemaCadastro.salvarCadastro(pessoa);
    }

    private static void buscar() {
        System.out.print("Digite o nome do arquivo (sem .json): ");
        String nomeArquivo = scanner.nextLine();
        SistemaCadastro.buscarCadastro(nomeArquivo);
    }
}
