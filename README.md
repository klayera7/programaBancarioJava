# 🏦 Sistema Básico de Conta Bancária em Java (POO)

Este é um projeto simples desenvolvido em **Java** que implementa a lógica fundamental de uma conta bancária, utilizando conceitos essenciais da **Programação Orientada a Objetos (POO)**.

Embora seja um projeto básico para muitos, completar esta tarefa com sucesso foi um marco de grande felicidade no meu avanço nos estudos de Java!

## 🎯 Objetivo do Projeto

O principal objetivo foi praticar o **Encapsulamento** e a **Sobrecarga de Construtores** (Constructor Overloading), simulando o fluxo de abertura de conta com regras de negócio específicas:

1.  **Abertura de Conta:** O saldo inicial é **opcional**.
2.  **Saldo Padrão:** Se o cliente não informar um valor inicial, o saldo é definido como **R$ 500,00**.
3.  **Transações:** Implementação de métodos para **depósito** e **saque** (com taxa de R$ 5,00 fixa).

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 21+)
* **Conceitos de POO:** Encapsulamento, Sobrecarga de Construtores (`Overloading`), e Sobrescrita (`@Override`).

## ⚙️ Como a Lógica Funciona

O projeto é dividido nas seguintes classes e funcionalidades:

| Classe | Descrição |
| :--- | :--- |
| `Usuarios.java` (Entidade) | Armazena os dados (`conta`, `nome`, `valor/saldo`). Contém múltiplos construtores e os métodos de negócio (`depositar`, `sacarValor`). |
| `DataHoraStatus.java` | Entidade usada em **Composição** para registrar a data, hora e o status de cada transação. |
| `OrderStatus.java` (Enum) | Define as constantes literais (`DEPOSITED`, `WITHDRAWN`) para melhor legibilidade. |
| `Main.java` (Programa Principal) | É a interface de usuário. Utiliza o *loop* **`do-while`** para apresentar um menu de operações repetível, mantendo o saldo atualizado. |

## 📚 Agradecimento

Este projeto foi proposto pelo curso do **Professor Nelio Alves** (Udemy). O desenvolvimento e a resolução dos desafios de lógica foram cruciais para consolidar o conhecimento em Java.
