import entities.Usuarios;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuarios usuario1;

        System.out.println("Digite os quatro números finais da sua conta:");
        int conta = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o seu nome e sobrenome:");
        String nome = sc.nextLine();

        System.out.println("Esse é o seu primeiro deposito? (s/n)");
        char resposta = sc.next().charAt(0);
        if (resposta == 's') {
            System.out.println("Digite o valor do seu deposito inicial:");
            double valorInicial = sc.nextDouble();
            usuario1 = new Usuarios(conta, nome, valorInicial);
        }
        else {
            usuario1 = new Usuarios(conta, nome);
        }

        sc.nextLine();

        System.out.println("\nDados Iniciais: " + usuario1.toString());

        System.out.println("\nDigite o novo valor do deposito: ");
        usuario1.depositar(sc.nextDouble());

        System.out.println(usuario1.toString());

        System.out.println("\nDigite o valor que você deseja sacar: ");
        usuario1.sacarValor(sc.nextDouble());

        System.out.println(usuario1.toString());


        sc.close();
    }
}