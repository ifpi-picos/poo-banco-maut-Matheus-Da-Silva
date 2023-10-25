public class ContaPoupanca extends Conta {
    private double rendimento;

    public ContaPoupanca(int numeroAgencia, int numeroConta, double saldo, double rendimento, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.rendimento = rendimento;
    }

    @Override
    public double sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            double taxa = valor * 0.05; // Taxa de 5% para saques
            super.sacar(valor + taxa); 
            return valor;
        } else {
            System.out.println("Saldo insuficiente");
            return 0;
        }
    }

    @Override
    public boolean depositar(double valor) {
        double rendimentoValor = valor * rendimento;
        double valorComRendimento = valor + rendimentoValor;
        return super.depositar(valorComRendimento);
    }

    @Override
    public void transferir(Conta destino, double valor) {
        double taxa = valor * 0.10; // Taxa de 10% para transferências
        
        if (valor > 0 && valor <= saldo) {
            saldo -= (valor + taxa);
            destino.saldo += valor;
            transacao.adicionarTransacao("Transferência", valor, obterDataHoraFormatada());
            destino.transacao.adicionarTransacao("Recebimento de Transferência", valor, obterDataHoraFormatada());

            if (notificacao != null) {
                notificacao.enviaNotificacao("Transferência", valor);
            } else {
                System.out.println("Nenhuma notificação configurada para a conta.");
            }
            
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}