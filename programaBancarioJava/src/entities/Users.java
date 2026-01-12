package entities;

public class Users {
    private int conta;
    private String nome;
    private double valor;


    public Users() {
        this.valor = 0.0;
    }

    public Users(int conta, String nome) {
        this.conta = conta;
        this.nome = nome;
        this.valor = 0;
    }

    public Users(int conta, String nome, double valorInicial) {
        this.conta = conta;
        this.nome = nome;
        this.valor = valorInicial;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void depositar(double quantia) {
        this.valor += quantia;
    }

    public void sacarValor(double quantia) {

        if (quantia <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser maior que zero.");
        }

        double taxa = 5.0;
        double total = quantia + taxa;

        if (valor < total) {
            throw new InsufficientBalance(
                    "Saldo insuficiente para saque. Saldo atual: R$ "
                            + String.format("%.2f", valor)
            );
        }

        this.valor -= total;
    }

    public int getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Usuário: "
                + nome
                + " | Conta: "
                + conta
                + " | Saldo: R$ "
                + String.format("%.2f", valor);
    }
}