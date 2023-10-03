import java.util.ArrayList;
import java.util.List;

public class Transacao {
    private List<String> transacoes;

    public Transacao() {
        this.transacoes = new ArrayList<>();
    }

    // Método para adicionar uma mensagem de transação
    public void adicionarTransacao(String mensagem) {
        transacoes.add(mensagem);
    }

    // Método para obter todas as transações
    public List<String> getTransacoes() {
        return transacoes;
    }

    // Método para limpar todas as transações
    public void limparTransacoes() {
        transacoes.clear();
    }
}