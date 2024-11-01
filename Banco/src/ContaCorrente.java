// Subclasse ContaCorrente
public class ContaCorrente extends Conta {

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Corrente:");
        System.out.println("Número da conta: " + this.getNumero());
        System.out.println("Saldo: " + this.getSaldo());
    }
}
