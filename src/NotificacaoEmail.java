public class NotificacaoEmail implements Notificacao {
    @Override
    public void enviaNotificacao(String operacao, double valor) {
        System.out.println("\nEnviando notificação por email - Operação: " + operacao + ", Valor: " + valor);
    }
}