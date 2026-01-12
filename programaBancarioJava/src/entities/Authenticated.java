package entities;

public interface Authenticated {
    boolean login(String password);

    default void notifyAccess(boolean success, String name) {
        if (success) {
            System.out.println("Acesso concedido: Usuário " + name + " acessou o sistema com sucesso!");
        }
        else {
            System.out.println("ALERTA: Tentativa de login inválida para o usuário: " + name);
        }
    }
}
