public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int transferenciasRestantes;

    public ContaCorrente(int numeroAgencia, int numeroConta, double saldo, double chequeEspecial, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.chequeEspecial = chequeEspecial;
        this.transferenciasRestantes = 2; // Inicialmente, 2 transferências sem taxa
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (valor <= (saldo + chequeEspecial)) {
            saldo -= valor;

            if (transferenciasRestantes > 0) {
                destino.depositar(valor); // Destino recebe um depósito
                transferenciasRestantes--;
            } else {
                double taxa = valor * 0.10; // Taxa de 10% para transferências adicionais
                super.sacar(taxa);
                destino.depositar(valor - taxa); // Desconta a taxa do destino
            }
            
            transacao.adicionarTransacao("Transferência", valor, obterDataHoraFormatada());
            System.out.println("Transferência concluída com êxito");
        } else {
            System.out.println("Saldo e cheque especial insuficientes");
        }
    }
}