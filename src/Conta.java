import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Conta {
    private String numeroAgencia;
    private String numeroConta;
    private double saldo;
    private Cliente cliente; // Uma conta só pode ter um cliente associado
    private Transacao transacao;

    public Conta(String numeroAgencia, String numeroConta, double saldo, Cliente cliente){
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
        cliente.adicionarConta(this); // Associa a conta ao cliente
        this.transacao = new Transacao(); // Inicialize o objeto de transação
    }    

    // Obtém a data e hora atuais
    Date dataHoraAtual = new Date();

    // Define o formato desejado para a data e hora
    SimpleDateFormat formato = new SimpleDateFormat("HH:mm - dd/MM/yyyy");

    // Formata a data e hora em uma string
    String dataHoraFormatada = formato.format(dataHoraAtual);
    
    public Conta(String numeroAgenciaDestino, String numeroContaDestino) {
        this.transacao = new Transacao();
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Método para depositar dinheiro na conta
    public void depositar(double valor){
        saldo += valor;
        transacao.adicionarTransacao("Depósito de R$" + valor + " às " + dataHoraFormatada);
        System.out.println("Depósito concluído com êxito");
    }

    // Método para sacar dinheiro da conta
    public void sacar(double valor){
        if (valor <= saldo){
            saldo -= valor;
            transacao.adicionarTransacao("Saque de R$" + valor + " às " + dataHoraFormatada);
            System.out.println("Saque concluído com êxito");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    // Método para transferir dinheiro para outra conta
    public void transferir(Conta destino, double valor){
        if (valor <= saldo){
            saldo -= valor;
            destino.depositar(valor);
            transacao.adicionarTransacao("Transferência de R$" + valor + " às " + dataHoraFormatada);
            System.out.println("Transferência concluída com êxito");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    // Método para obter transações
    public List<String> obterTransacoes() {
        return transacao.getTransacoes();
    }

    // Método para limpar transações
    public void limparTransacoes() {
        transacao.limparTransacoes();
    }
}