
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
