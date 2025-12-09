package entities;

public class UsuariosBusiness extends Usuarios {

    private String CNPJ;

    public UsuariosBusiness() {
        super();
    }

    public UsuariosBusiness(int conta, String nome, double valorInicial, String CNPJ) {
        super(0, nome, valorInicial);
        this.CNPJ = CNPJ;
    }

    @Override
    public String toString() {
        return "CNPJ: "
                + CNPJ + " | Razão Social: "
                + getNome()
                + " | Saldo: R$ "
                + String.format("%.2f", getValor());
    }
}