import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação do cliente
        System.out.println("Bem-vindo ao Banco Maut. Por favor, insira seus dados para criar uma conta:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);
        Conta conta = new Conta("001", "001", 0, cliente);

        while (true) {
            System.out.println("\n//-- Banco Maut --//");
            System.out.println("Escolha uma operação:");
            System.out.println("1 - Exibir informações");
            System.out.println("2 - Ver Saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Exibir Extrato");
            System.out.println("7 - Alterar Dados");
            System.out.println("8 - Sair");
            System.out.print("\nOpção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("\nInformações do Cliente e da Conta:");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCPF());
                    System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
                    System.out.println("Endereço: " + cliente.getEndereco());
                    System.out.println("Número da Agência: " + conta.getNumeroAgencia());
                    System.out.println("Número da Conta: " + conta.getNumeroConta());
                    System.out.println("Saldo: R$" + conta.getSaldo());
                    break;

                case 2:
                    System.out.println("\nSaldo: R$" + conta.getSaldo());
                    break;

                case 3:
                    System.out.println("\n//-- Depósito --//");
                    System.out.print("Valor a depositar: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;

                case 4:
                    System.out.println("\n//-- Saque --//");
                    System.out.print("Valor a sacar: R$");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;

                case 5:
                    System.out.println("\n//-- Transferência --//");
                    System.out.print("Número da Agência de Destino: ");
                    String numeroAgenciaDestino = scanner.nextLine();
                    System.out.print("Número da Conta de Destino: ");
                    String numeroContaDestino = scanner.nextLine();
                    
                    Conta destino = new Conta(numeroAgenciaDestino, numeroContaDestino);
                
                    System.out.print("Valor a transferir: R$");
                    double valorTransferencia = scanner.nextDouble();
                    conta.transferir(destino, valorTransferencia);
                    break;

                case 6:
                    System.out.println("\nExtrato de Transações:");
                    for (String transacao : conta.obterTransacoes()) {
                        System.out.println(transacao);
                    }
                    break;

                case 7:
                    System.out.println("\n//-- Alterar Dados --//");
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    cliente.setNome(novoNome);
                    System.out.print("Nova Data de Nascimento: ");
                    String novoDataNasc = scanner.nextLine();
                    cliente.setDataNascimento(novoDataNasc);
                    System.out.print("Novo Endereço: ");
                    String novoEndereco = scanner.nextLine();
                    cliente.setEndereco(novoEndereco);
                    System.out.println("Informações atualizadas com sucesso.");
                    break;

                case 8:
                    System.out.println("Até logo!");
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}