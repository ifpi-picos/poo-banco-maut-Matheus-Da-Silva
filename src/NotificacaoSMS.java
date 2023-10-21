public class NotificacaoSMS implements Notificacao {
    @Override
    public void enviaNotificacao(String operacao, double valor) {
        System.out.println("\nEnviando notificação por SMS - Operação: " + operacao + ", Valor: " + valor);
    }
}