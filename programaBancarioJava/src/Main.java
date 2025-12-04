import entities.DataHoraStatus;
import entities.OrderStatus;
import entities.Usuarios;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuarios usuario1;
        char opcao;

        System.out.println("--- BEM-VINDO AO CAIXA ELETRÔNICO ---");
        System.out.println();
        System.out.println("Qual o tipo de conta? [F] Física / [J] Jurídica: ");
        char tipoConta = sc.next().toUpperCase().charAt(0);

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
                usuario1 = new Usuarios(conta, nome, valorInicial);
            } else {
                usuario1 = new Usuarios(conta, nome, 500);
            }
            sc.nextLine();

            System.out.println("\n*** ACESSO CONCEDIDO ***");
            System.out.println("Status atual: " + usuario1.toString());

            do {
                System.out.println("\n-------------------------------------");
                System.out.println("Escolha uma operação:");
                System.out.println("[D] Depósito");
                System.out.println("[S] Saque (taxa de R$ 5,00)");
                System.out.println("[E] Encerrar Sessão");
                System.out.print("Opção: ");

                opcao = sc.next().toUpperCase().charAt(0);
                sc.nextLine();

                if (opcao == 'D') {
                    System.out.print("Valor do depósito: ");
                    usuario1.depositar(sc.nextDouble());
                    System.out.println();

                    DataHoraStatus registro = new DataHoraStatus(new Date(), OrderStatus.DEPOSITED);
                    System.out.println(registro.toString());
                }
                else if (opcao == 'S') {
                    System.out.print("Valor do saque: ");
                    usuario1.sacarValor(sc.nextDouble());
                    System.out.println();

                    DataHoraStatus registro = new DataHoraStatus(new Date(), OrderStatus.WITHDRAWN);
                    System.out.println(registro.toString());
                }
                else if (opcao == 'E') {
                    System.out.println("\nSessão encerrada. Até logo, " + usuario1.getNome() + "!");
                }
                else {
                    System.out.println("Opção inválida. Tente D, S ou E.");
                }

                if (opcao != 'E') {
                    System.out.println("Saldo Atual: " + usuario1.toString());
                }

            } while (opcao != 'E');

        } else if (tipoConta == 'J') {
            System.out.println("teste");
        }

        sc.close();
    }
}