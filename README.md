# Restaurant Order Management System

Sistema de gerenciamento de pedidos para restaurante desenvolvido em Java com foco em Programação Orientada a Objetos, separação de responsabilidades e regras de negócio.

O projeto simula o fluxo completo de um restaurante:

- criação de pedidos;
- seleção de itens do cardápio;
- cálculo de subtotal;
- aplicação de descontos;
- taxa de serviço;
- processamento de pagamento;
- controle de status do pedido.

---

# Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Collections (`List`)
- Enums
- Exceptions personalizadas
- Estrutura em camadas:
  - `entities`
  - `services`
  - `exceptions`
  - `enums`

---

# Estrutura do Projeto

```text
src
├── application
│   └── Program.java
│
├── model
│   ├── entities
│   ├── enums
│   ├── exceptions
│   └── services
```

---

# Funcionalidades

## Pedidos

- Criar novos pedidos
- Associar pedido a uma mesa
- Adicionar múltiplos itens
- Exibir resumo completo do pedido

## Cardápio

- Cardápio dinâmico utilizando listas
- Categorias separadas:
  - Hambúrgueres
  - Bebidas
  - Sobremesas

## Regras de Negócio

- Validação de quantidade
- Validação de número da mesa
- Happy Hour com desconto em bebidas
- Taxa de serviço de 10%
- Controle de status do pedido
- Impedimento de pagamento duplicado

## Pagamentos

- PIX
- Cartão de Débito
- Cartão de Crédito
- Dinheiro

---

# Conceitos Aplicados

## Programação Orientada a Objetos

- Encapsulamento
- Associações entre classes
- Responsabilidade única
- Separação de camadas

## Boas práticas

- Uso de Services para regras de negócio
- Exceptions customizadas
- Uso de Enums para estados e categorias
- Métodos auxiliares privados
- Código organizado por responsabilidade

---

# Estrutura das Principais Classes

## Entities

- `Order`
- `OrderItem`
- `MenuItem`

## Services

- `OrderService`
- `PaymentService`

## Enums

- `MenuCategory`
- `OrderStatus`
- `PaymentMethod`

## Exceptions

- `InvalidQuantityException`
- `InvalidTableException`
- `OrderAlreadyPaidException`

---

# Regras Implementadas

## Happy Hour

Pedidos realizados entre:

```text
15:00 até 17:59
```

recebem:

```text
20% de desconto em bebidas
```

---

## Taxa de Serviço

Todos os pedidos possuem:

```text
10% de taxa de serviço
```

---

# Como Executar

## 1. Clone o repositório

```bash
git clone https://github.com/kaua-menezes-dev/restaurant-order-management-java.git
```

## 2. Abra o projeto na sua IDE Java de preferência

Exemplo:
- IntelliJ IDEA
- Eclipse
- VS Code

## 3. Execute a classe principal

```text
Program.java
```

---

# Fluxo do Sistema

1. Usuário informa a mesa
2. Sistema cria o pedido
3. Usuário escolhe itens do cardápio
4. Sistema adiciona os itens ao pedido
5. Usuário finaliza o pedido
6. Sistema calcula:
   - subtotal
   - desconto
   - taxa de serviço
   - total final
7. Usuário escolhe forma de pagamento
8. Sistema processa o pagamento
9. Pedido é finalizado

---

# Objetivo do Projeto

Este projeto foi desenvolvido com foco em:

- prática de lógica de programação;
- consolidação de Programação Orientada a Objetos;
- modelagem de domínio;
- construção de regras de negócio;
- organização de projetos Java backend.

---

# Melhorias Futuras

- Persistência em banco de dados
- Camada Repository
- Interface gráfica
- API REST com Spring Boot
- Controle de estoque
- Login de funcionários
- Histórico de pedidos
- Testes automatizados

---

# Autor

Desenvolvido por Kauã Menezes.
