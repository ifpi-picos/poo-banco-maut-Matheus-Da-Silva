import java.util.ArrayList;
import java.util.List;

public class Transacao {
    private String tipo;
    private double valor;
    private String data;

    public Transacao(String tipo, double valor, String data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }
    
    private List<Transacao> transacoes; // Altere o tipo da lista para armazenar objetos Transacao

    public Transacao() {
        this.transacoes = new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    // Método para adicionar uma transação com tipo, valor e data
    public void adicionarTransacao(String tipo, double valor, String data) {
        Transacao transacao = new Transacao(tipo, valor, data);
        transacoes.add(transacao);
    }

    // Método para obter todas as transações
    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public String toString() {
        return tipo + " de R$" + valor + " às " + data;
    }


    // Método para limpar todas as transações
    public void limparTransacoes() {
        transacoes.clear();
    }
}