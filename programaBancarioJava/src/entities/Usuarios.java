package entities;

public class Usuarios {
    private int conta;
    private String nome;
    private double valor;


    public Usuarios() {
        this.valor = 0.0;
    }

    public Usuarios(int conta, String nome) {
        this.conta = conta;
        this.nome = nome;
        this.valor = 0;
    }

    public Usuarios(int conta, String nome, double valorInicial) {
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
        this.valor -= quantia + 5;
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