import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Conta {
    private int numeroAgencia;
    private int numeroConta;
    protected double saldo;
    private Cliente cliente; // Uma conta só pode ter um cliente associado
    protected Transacao transacao;
    private Notificacao notificacao;

    public Conta(int numeroAgencia, int numeroConta, double saldo, Cliente cliente){
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
        cliente.adicionarConta(this); // Associa a conta ao cliente
        this.transacao = new Transacao(); // Inicialize o objeto de transação
    }    
    
    // Método privado para obter a data e hora formatada
    protected String obterDataHoraFormatada() {
        Date dataHoraAtual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm - dd/MM/yyyy");
        return formato.format(dataHoraAtual);
    }
    
    public Conta(String numeroAgenciaDestino, String numeroContaDestino) {
        this.transacao = new Transacao();
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    // Método para depositar dinheiro na conta
    public boolean depositar(double valor){
        saldo += valor;
        transacao.adicionarTransacao("Depósito", valor, obterDataHoraFormatada());

        if (notificacao != null) {
                notificacao.enviaNotificacao("Depósito", valor);
            } else {
                System.out.println("Nenhuma notificação configurada para a conta.");
        }

        System.out.println("Depósito concluído com êxito");
        return false;
    }

    // Método para sacar dinheiro da conta
    public double sacar(double valor){
        if (valor > 0 && valor <= saldo){
            saldo -= valor;
            transacao.adicionarTransacao("Saque", valor, obterDataHoraFormatada());

            if (notificacao != null) {
                notificacao.enviaNotificacao("Saque", valor);
            } else {
                System.out.println("Nenhuma notificação configurada para a conta.");
            }

            System.out.println("Saque concluído com êxito");
        } else {
            System.out.println("Saldo insuficiente");
        }
        return valor;
    }

    // Método para transferir dinheiro para outra conta
    public void transferir(Conta destino, double valor){
        if (valor <= saldo){
            saldo -= valor;
            destino.depositar(valor);
            transacao.adicionarTransacao("Transferência", valor, obterDataHoraFormatada());

            if (notificacao != null) {
                notificacao.enviaNotificacao("Transferência", valor);
            } else {
                System.out.println("Nenhuma notificação configurada para a conta.");
            }

            System.out.println("Transferência concluída com êxito");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    // Método para obter transações
    public List<Transacao> obterTransacoes() {
        return transacao.getTransacoes();
    }
}