public class ContaPoupanca extends Conta {
    private double rendimento;

    public ContaPoupanca(int numeroAgencia, int numeroConta, double saldo, double rendimento, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.rendimento = rendimento;
    }

    
}