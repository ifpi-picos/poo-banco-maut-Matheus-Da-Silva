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
        double taxa = valor * 0.10; // Taxa de 10% para transferências adicionais

        if (valor > 0 && valor <= (saldo + chequeEspecial)) {
            saldo -= valor;

            if (transferenciasRestantes > 0) {
                destino.saldo += valor; // Destino deve receber um depósito
                transferenciasRestantes--;
            } else {
                saldo -= (valor + taxa);
                destino.saldo += (valor); // Desconta a taxa do destino
            }
            
            transacao.adicionarTransacao("Transferência", valor, obterDataHoraFormatada());
            destino.transacao.adicionarTransacao("Recebimento de Transferência", valor, obterDataHoraFormatada());
            System.out.println("Transferência concluída com êxito");
        } else {
            System.out.println("Saldo e cheque especial insuficientes");
        }
    }
}