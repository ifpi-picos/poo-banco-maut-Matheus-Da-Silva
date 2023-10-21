public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int transferenciasRestantes;

    public ContaCorrente(int numeroAgencia, int numeroConta, double saldo, double chequeEspecial, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.chequeEspecial = chequeEspecial;
        this.transferenciasRestantes = 2; // Inicialmente, 2 transferências sem taxa
    }

    
}