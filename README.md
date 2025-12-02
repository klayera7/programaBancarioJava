# 🏦 Sistema Bancário em Java (Backend)

Este repositório contém a implementação de um sistema bancário fundamental desenvolvido em **Java**. O projeto aplica conceitos sólidos de **Programação Orientada a Objetos (POO)** para simular operações financeiras reais, servindo como base para meus estudos avançados em desenvolvimento de software.

## 🚀 Projeto em Evolução Contínua

Este é um **"Living Project"** (Projeto Vivo). O código aqui presente não é estático; ele é refatorado e expandido frequentemente à medida que avanço nos meus estudos sobre Design Patterns, Clean Code e novas tecnologias do ecossistema Java.

* **Estágio Atual:** Backend funcional com interface via console (CLI).
* **Próximos Passos:** Implementação de persistência de dados (Banco de Dados) e APIs.
* **Objetivo Final:** Integrar este backend robusto a uma interface **Front-end** moderna, completando o ciclo de uma aplicação Full Stack.

## 🎯 Funcionalidades e Regras de Negócio

O sistema foi projetado para validar regras essenciais de uma conta corrente:

1.  **Abertura Flexível:** Instanciação de contas com ou sem depósito inicial.
2. **Taxas Administrativas:** Aplicação automática de taxa de **R$ 5,00** em operações de saque.
3. **Rastreabilidade:** Cada transação gera um registro com carimbo de data/hora e status.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 21+)
* **IDE:** IntelliJ IDEA
* **Conceitos Chave:** Encapsulamento, Sobrecarga de Construtores, Enums e Composição.

## 📂 Estrutura do Código

O projeto segue uma arquitetura organizada para facilitar a escalabilidade:

| Pacote / Arquivo | Responsabilidade |
| :--- | :--- |
| `src/entities/Usuarios.java` | **Core**. Gerencia dados sensíveis (titular, saldo) e lógica de transações (saque/depósito). |
| `src/entities/DataHoraStatus.java` | **Utilitário**. Classe responsável por registrar o *timestamp* exato de cada operação. |
| `src/entities/OrderStatus.java` | **Enum**. Define estados imutáveis (`DEPOSITED`, `WITHDRAWN`) para garantir a consistência dos dados. |
| `src/Main.java` | **Aplicação**. Ponto de entrada que gerencia o fluxo de interação com o usuário via terminal. |

## 📦 Como Executar

1.  Clone este repositório.
2.  Abra a pasta do projeto no **IntelliJ IDEA**.
3.  Localize o arquivo `src/Main.java`.
4.  Execute o arquivo para iniciar o menu interativo no console.

---