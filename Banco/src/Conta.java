// Classe abstrata Conta
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
