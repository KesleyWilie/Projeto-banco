
// Subclasse ContaPoupanca
public class ContaPoupanca extends Conta {

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupança:");
        System.out.println("Número da conta: " + this.getNumero());
        System.out.println("Saldo: " + this.getSaldo());
    }
}
