# 🏦 Sistema Bancário em Java (Backend)

Este repositório contém a implementação de um sistema bancário fundamental desenvolvido em **Java**. O projeto aplica conceitos sólidos de **Programação Orientada a Objetos (POO)** para simular operações financeiras reais, servindo como base para meus estudos avançados em desenvolvimento de software.

## 🚀 Projeto em Evolução Contínua

Este é um **"Living Project"** (Projeto Vivo). O código aqui presente não é estático; ele é refatorado e expandido frequentemente à medida que avanço nos meus estudos sobre Design Patterns, Clean Code e novas tecnologias do ecossistema Java.

* **Estágio Atual:** Backend funcional com suporte a Contas Físicas e Jurídicas, além de camada de segurança via Interfaces.
* **Próximos Passos:** Implementação de persistência de dados (Banco de Dados) e APIs.
* **Objetivo Final:** Integrar este backend robusto a uma interface **Front-end** moderna, completando o ciclo de uma aplicação Full Stack.

## 🎯 Funcionalidades e Regras de Negócio

O sistema foi projetado para validar regras essenciais de uma conta corrente:

1.  **Abertura Flexível:** Instanciação de contas com ou sem depósito inicial.
2.  **Segurança por Contrato:** Sistema de autenticação obrigatório para acesso às operações através de interfaces.
3.  **Especialização de Contas:** Diferenciação entre usuários comuns e contas empresariais (Business) via herança.
4.  **Taxas Administrativas:** Aplicação automática de taxa de **R$ 5,00** em operações de saque.
5.  **Rastreabilidade:** Cada transação gera um registro com carimbo de data/hora e status.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 21+)
* **IDE:** IntelliJ IDEA
* **Conceitos Chave:** Encapsulamento, Herança, Polimorfismo, Sobrecarga de Construtores, Enums, Interfaces (Default Methods) e Tratamento de Exceções.

## 📂 Estrutura do Código

O projeto segue uma arquitetura organizada para facilitar a escalabilidade:

| Pacote / Arquivo | Responsabilidade |
| :--- | :--- |
| `src/entities/Users.java` | **Classe Base**. Gerencia dados do titular, saldo e lógica de transações. |
| `src/entities/BusinessUsers.java` | **Especialização**. Estende a classe base para atender contas de Pessoa Jurídica (CNPJ). |
| `src/entities/Authenticated.java` | **Interface**. Define o contrato de segurança e fornece logs automáticos de acesso via *Default Method*. |
| `src/entities/DateTimeStatus.java` | **Utilitário**. Classe responsável por registrar o *timestamp* exato de cada operação. |
| `src/entities/OrderStatus.java` | **Enum**. Define estados imutáveis (`DEPOSITED`, `WITHDRAWN`). |
| `src/entities/BankStatement.java` | **Persistência**. Gerencia o armazenamento temporário do histórico e a exportação dos dados. |
| `src/Main.java` | **Aplicação**. Ponto de entrada que gerencia o fluxo de autenticação e interação com o usuário. |

## 📦 Como Executar

1.  Clone este repositório.
2.  Certifique-se de que o JDK 21 ou superior está instalado.
3.  Localize o arquivo `src/Main.java`.
4.  Execute o arquivo para iniciar o menu interativo no console. O sistema solicitará autenticação para prosseguir, por padrão "123", podendo ser alterada na classe `src/entities/Users.java`.