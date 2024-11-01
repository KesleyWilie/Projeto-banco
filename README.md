# Banco Digital Orientado a Objetos

## Descrição do Desafio

Este projeto simula um sistema bancário orientado a objetos em Java. O banco oferece aos seus clientes dois tipos de contas - Conta Corrente e Conta Poupança - e permite realizar operações básicas como **depósito**, **saque** e **transferência** entre contas da mesma instituição.

O desafio é implementar esse sistema aplicando os principais conceitos da Programação Orientada a Objetos: **Abstração**, **Encapsulamento**, **Herança** e **Polimorfismo**.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

- **Conta (classe abstrata)**: Define os métodos e atributos comuns a todas as contas, como `numero`, `saldo`, `depositar`, `sacar`, e `transferir`. 
- **ContaCorrente (classe concreta)**: Extende `Conta` e implementa o método `imprimirExtrato`, específico para contas correntes.
- **ContaPoupanca (classe concreta)**: Extende `Conta` e implementa o método `imprimirExtrato`, específico para contas poupança.
- **BancoApp**: Classe de teste que demonstra a criação de contas e o uso das operações.

## Conceitos Utilizados

### 1. Abstração
A classe `Conta` é uma abstração de uma conta bancária. Ela concentra apenas os atributos e métodos essenciais para representar uma conta, ignorando detalhes irrelevantes para o contexto.

### 2. Encapsulamento
Os atributos de `Conta` são `private`, e o acesso a eles é feito exclusivamente através de métodos públicos (`getSaldo`, `depositar`, `sacar`, `transferir`), garantindo proteção do estado interno da classe.

### 3. Herança
As classes `ContaCorrente` e `ContaPoupanca` herdam a classe base `Conta`, permitindo reutilizar e especializar o comportamento comum das contas.

### 4. Polimorfismo
O sistema permite que instâncias de `ContaCorrente` e `ContaPoupanca` sejam referenciadas como `Conta`, o que facilita o uso de métodos comuns de forma unificada, como no caso do método `transferir`.

## Implementação

### Classe Conta

```java
public abstract class Conta {
    private static int SEQUENCIAL = 1;
    private int numero;
    private double saldo;

    public Conta() {
        this.numero = SEQUENCIAL++;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            this.saldo -= valor;
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    public abstract void imprimirExtrato();
}
```

### Classe ContaCorrente

```java
public class ContaCorrente extends Conta {
    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Corrente:");
        System.out.println("Número da conta: " + this.getNumero());
        System.out.println("Saldo: " + this.getSaldo());
    }
}
```

### Classe ContaPoupanca

```java
public class ContaPoupanca extends Conta {
    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupança:");
        System.out.println("Número da conta: " + this.getNumero());
        System.out.println("Saldo: " + this.getSaldo());
    }
}
```

### Classe BancoApp (Classe de Teste)

```java
public class BancoApp {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();

        cc.depositar(1000);
        cc.transferir(250, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
```

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/falvojr/lab-banco-digital-oo.git
   ```
   
2. Navegue até a pasta do projeto:
   ```bash
   cd lab-banco-digital-oo/src
   ```

3. Compile o projeto:
   ```bash
   javac BancoApp.java
   ```

4. Execute o programa:
   ```bash
   java BancoApp
   ```

## Resultado Esperado

A execução do código deve exibir o extrato de cada conta com os valores atualizados após o depósito e a transferência, semelhante ao exemplo abaixo:

```
Extrato Conta Corrente:
Número da conta: 1
Saldo: 750.0

Extrato Conta Poupança:
Número da conta: 2
Saldo: 250.0
```

## Autor
Este projeto foi desenvolvido com o objetivo de reforçar os conceitos de Programação Orientada a Objetos. 

---

## Licença

Distribuído sob a licença MIT. Consulte `LICENSE` para mais informações.
```

Esse arquivo fornece uma visão completa do projeto, explicando o propósito, estrutura, conceitos usados, e instruções para execução.
