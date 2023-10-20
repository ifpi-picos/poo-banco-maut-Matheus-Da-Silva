import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Conta {
    private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    private Cliente cliente; // Uma conta só pode ter um cliente associado
    private Transacao transacao;

    public Conta(int numeroAgencia, int numeroConta, double saldo, Cliente cliente){
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
        cliente.adicionarConta(this); // Associa a conta ao cliente
        this.transacao = new Transacao(); // Inicialize o objeto de transação
    }    
    
    // Método privado para obter a data e hora formatada
    private String obterDataHoraFormatada() {
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

    // Método para depositar dinheiro na conta
    public boolean depositar(double valor){
        saldo += valor;
        transacao.adicionarTransacao("Depósito", valor, obterDataHoraFormatada());
        System.out.println("Depósito concluído com êxito");
        return false;
    }

    // Método para sacar dinheiro da conta
    public double sacar(double valor){
        if (valor <= saldo){
            saldo -= valor;
            transacao.adicionarTransacao("Saque", valor, obterDataHoraFormatada());
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
            System.out.println("Transferência concluída com êxito");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    // Método para obter transações
    public List<Transacao> obterTransacoes() {
        return transacao.getTransacoes();
    }

    // Método para limpar transações
    public void limparTransacoes() {
        transacao.limparTransacoes();
    }
}