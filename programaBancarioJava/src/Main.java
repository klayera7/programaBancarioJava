import entities.*;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Users usuario1 = null;
        char opcao;
        BankStatement extrato = new BankStatement();

        System.out.println("--- BEM-VINDO AO CAIXA ELETRÔNICO ---");
        System.out.println();
        while (usuario1 == null) {
            System.out.print("Qual o tipo de conta? [F] Física / [J] Jurídica: ");
            char tipoConta = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

            try {
                if (tipoConta == 'F') {
                    System.out.print("Digite os quatro números finais da sua conta: ");
                    int conta = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite o seu nome e sobrenome: ");
                    String nome = sc.nextLine();

                    System.out.print("É o seu primeiro depósito? (s/n): ");
                    char resposta = sc.next().charAt(0);

                    if (resposta == 's') {
                        System.out.print("Digite o valor do depósito inicial: ");
                        double valorInicial = sc.nextDouble();
                        usuario1 = new Users(conta, nome, valorInicial);
                    } else {
                        usuario1 = new Users(conta, nome, 500);
                    }
                    sc.nextLine();

                } else if (tipoConta == 'J') {
                    System.out.print("Digite a Razão Social: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o seu CNPJ: ");
                    String CNPJ = sc.nextLine();

                    System.out.print("É o seu primeiro depósito? (s/n): ");
                    char resposta = sc.next().charAt(0);

                    if (resposta == 's') {
                        System.out.print("Digite o valor do depósito inicial: ");
                        double valorInicial = sc.nextDouble();
                        usuario1 = new BusinessUsers(0, nome, valorInicial, CNPJ);
                    } else {
                        usuario1 = new BusinessUsers(0, nome, 500.00, CNPJ);
                    }
                    sc.nextLine();

                } else {
                    System.out.println(" ");
                    System.out.println("Tipo de conta inválido. tente [F] ou [J].");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ocorreu um erro inesperado.");
                sc.nextLine();
            }
        }

        System.out.println("\n-------------------------------------");
        System.out.print("Digite sua senha para acessar a conta: ");
        String senhaDigitada = sc.nextLine();

        if (!usuario1.login(senhaDigitada)) {
            System.out.println("ERRO: Senha inválida.");
            usuario1.notifyAccess(false, usuario1.getNome() + " [TENTATIVA DE INVASÃO]");
            sc.close();
            return;
        }

        usuario1.notifyAccess(true, usuario1.getNome());
        System.out.println("\n*** ACESSO CONCEDIDO ***");
        System.out.println("Status inicial: " + usuario1.toString());

        do {
            System.out.println("\n-------------------------------------");
            System.out.println("Escolha uma operação:");
            System.out.println("[D] Depósito");
            System.out.println("[S] Saque (taxa de R$ 5,00)");
            System.out.println("[T] Gerar Extrato");
            System.out.println("[E] Encerrar Sessão");
            System.out.print("Opção: ");

            opcao = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

            if (opcao == 'D') {

                try{
                    System.out.print("Valor do depósito: ");
                    Double valorDep = sc.nextDouble();
                    sc.nextLine();

                    usuario1.depositar(valorDep);

                    DateTimeStatus registro = new DateTimeStatus(new Date(), OrderStatus.DEPOSITED);
                    System.out.println(registro.toString());
                    extrato.addTransacao("DEPÓSITO | " + registro.toString() + " | Valor: R$ " + valorDep);

                } catch (InputMismatchException e) {
                    System.out.println("Erro, digite apenas numeros.");
                    System.out.println("");
                    sc.nextLine();

                } finally {
                    System.out.println("Operação de deposito finalizada.");
                    System.out.println("");
                }


            }
            else if (opcao == 'S') {

                try {
                    System.out.print("Valor do saque: ");
                    double valorSaque = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("");

                    usuario1.sacarValor(valorSaque);

                    DateTimeStatus registro = new DateTimeStatus(new Date(), OrderStatus.WITHDRAWN);
                    System.out.println(registro.toString());
                    extrato.addTransacao("SAQUE | " + registro.toString() + " | Valor: R$ " + valorSaque);

                } catch (InsufficientBalance e) {
                    System.out.println("ERRO: " + e.getMessage());

                } catch (InputMismatchException e) {
                    System.out.println("Erro, digite apenas numeros.");
                    System.out.println("");
                    sc.nextLine();

                } catch (Exception e) {
                    System.out.println("Erro inesperado.");

                } finally {
                    System.out.println("Operação de saque finalizada.");
                    System.out.println("");
                }
            }
            else if (opcao == 'T') {
                extrato.gerarExtrato();
            }

            else if (opcao == 'E') {
                System.out.println("\nSessão encerrada. Até logo, " + usuario1.getNome() + "!");
            }
            else {
                System.out.println("Opção inválida. Tente D, S, T ou E.");
            }

            if (opcao != 'E') {
                System.out.println("Saldo Atual: " + usuario1.toString());
            }

        } while (opcao != 'E');

        sc.close();
    }
}