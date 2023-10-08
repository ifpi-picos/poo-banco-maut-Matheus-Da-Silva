import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();
        Conta contaAtiva = null;

        while (true) {
            System.out.println("\n//-- Banco Maut --//");
            System.out.println("Escolha uma operação:");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Ativar/Trocar de Conta");
            System.out.println("3 - Excluir Conta");
            System.out.println("4 - Exibir informações");
            System.out.println("5 - Ver Saldo");
            System.out.println("6 - Depositar");
            System.out.println("7 - Sacar");
            System.out.println("8 - Transferir");
            System.out.println("9 - Exibir Extrato");
            System.out.println("10 - Alterar Dados");
            System.out.println("11 - Sair");
            System.out.print("\nOpção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa a quebra de linha

            switch (opcao) {
                case 1:
                    Conta novaConta = criarConta(scanner);
                    if (novaConta != null) {
                        contas.add(novaConta);
                    }
                    break;

                case 2:
                    if (contas.isEmpty()) {
                        System.out.println("Nenhuma conta cadastrada.");
                    } else {
                        System.out.print("Digite o número da conta que deseja ativar: ");
                        String numeroContaAtivar = scanner.nextLine();
                        contaAtiva = encontrarContaPorNumero(contas, numeroContaAtivar, numeroContaAtivar);
                        if (contaAtiva == null) {
                            System.out.println("Conta não encontrada.");
                        } else {
                            System.out.println("Conta " + numeroContaAtivar + " ativada.");
                        }
                    }
                    break;

                case 3:
                    if (contas.isEmpty()) {
                        System.out.println("Nenhuma conta cadastrada.");
                    } else {
                        System.out.print("Digite o número da conta que deseja excluir: ");
                        String numeroContaExcluir = scanner.nextLine();
                        Conta contaExcluir = encontrarContaPorNumero(contas, numeroContaExcluir, numeroContaExcluir);
                        if (contaExcluir == null) {
                            System.out.println("Conta não encontrada.");
                        } else {
                            contas.remove(contaExcluir);
                            System.out.println("Conta " + numeroContaExcluir + " excluída com sucesso.");
                        }
                    }
                    break;

                case 4:
                    if (contaAtiva != null) {
                        exibirInformacoesConta(contaAtiva);
                    } else {
                        System.out.println("Nenhuma conta ativa. Selecione uma conta antes de prosseguir.");
                    }
                    break;

                case 5:
                    if (contaAtiva != null) {
                        System.out.println("\nSaldo: R$" + contaAtiva.getSaldo());
                    } else {
                        System.out.println("Nenhuma conta ativa. Selecione uma conta antes de prosseguir.");
                    }
                    break;

                case 6:
                    if (contaAtiva != null) {
                        System.out.println("\n//-- Depósito --//");
                        System.out.print("Valor a depositar: R$");
                        double valorDeposito = scanner.nextDouble();
                        contaAtiva.depositar(valorDeposito);
                    } else {
                        System.out.println("Nenhuma conta ativa. Selecione uma conta antes de prosseguir.");
                    }
                    break;

                case 7:
                    if (contaAtiva != null) {
                        System.out.println("\n//-- Saque --//");
                        System.out.print("Valor a sacar: R$");
                        double valorSaque = scanner.nextDouble();
                        contaAtiva.sacar(valorSaque);
                    } else {
                        System.out.println("Nenhuma conta ativa. Selecione uma conta antes de prosseguir.");
                    }
                    break;

                case 8:
                    if (contaAtiva != null) {
                        System.out.println("\n//-- Transferência --//");
                        System.out.print("Número da Agência de Destino: ");
                        String numeroAgenciaDestino = scanner.nextLine();
                        System.out.print("Número da Conta de Destino: ");
                        String numeroContaDestino = scanner.nextLine();
                    
                        Conta destino = encontrarContaPorNumero(contas, numeroAgenciaDestino, numeroContaDestino);

                        if (destino != null) {
                            System.out.print("Valor a transferir: R$");
                            double valorTransferencia = scanner.nextDouble();
                            contaAtiva.transferir(destino, valorTransferencia);
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                        }
                    } else {
                        System.out.println("Nenhuma conta ativa. Selecione uma conta antes de prosseguir.");
                    }
                    break;

                case 9:
                    if (contaAtiva != null) {
                        System.out.println("\nExtrato de Transações:");
                        for (String transacao : contaAtiva.obterTransacoes()) {
                            System.out.println(transacao);
                        }
                    } else {
                        System.out.println("Nenhuma conta ativa. Selecione uma conta antes de prosseguir.");
                    }
                    break;

                case 10:
                    if (contaAtiva != null) {
                        System.out.println("\n//-- Alterar Dados --//");
                        System.out.print("Novo Nome: ");
                        String novoNome = scanner.nextLine();
                        contaAtiva.getCliente().setNome(novoNome);

                        System.out.print("Nova Data de Nascimento: ");
                        String novoDataNasc = scanner.nextLine();
                        contaAtiva.getCliente().setDataNascimento(novoDataNasc);

                        Endereco endereco = contaAtiva.getCliente().getEndereco();
                        System.out.println("\nNovo Endereço:");
                        System.out.print("Rua: ");
                        String novaRua = scanner.nextLine();
                        endereco.setRua(novaRua);

                        System.out.print("Número: ");
                        String novoNumero = scanner.nextLine();
                        endereco.setNumero(novoNumero);

                        System.out.print("Complemento: ");
                        String novoComplemento = scanner.nextLine();
                        endereco.setComplemento(novoComplemento);

                        System.out.print("Bairro: ");
                        String novoBairro = scanner.nextLine();
                        endereco.setBairro(novoBairro);

                        System.out.print("Cidade: ");
                        String novaCidade = scanner.nextLine();
                        endereco.setCidade(novaCidade);

                        System.out.print("Estado: ");
                        String novoEstado = scanner.nextLine();
                        endereco.setEstado(novoEstado);

                        System.out.print("País: ");
                        String novoPais = scanner.nextLine();
                        endereco.setPais(novoPais);

                        System.out.print("CEP: ");
                        String novoCep = scanner.nextLine();
                        endereco.setCEP(novoCep);

                        System.out.println("Informações atualizadas com sucesso.");
                    } else {
                        System.out.println("Nenhuma conta ativa. Selecione uma conta antes de prosseguir.");
                    }
                    break;

                case 11:
                    System.out.println("Até logo!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Métodos auxiliares
    private static Conta criarConta(Scanner scanner) {
        System.out.println("//-- Cadastro --//");
        System.out.print("Número da Agência: ");
        String numeroAgencia = scanner.nextLine();
        System.out.print("Número da Conta: ");
        String numeroConta = scanner.nextLine();

        Cliente cliente = criarCliente(scanner);
        Conta novaConta = new Conta(numeroAgencia, numeroConta, 0, cliente);

        System.out.println("Conta cadastrada com sucesso.");
        return novaConta;
    }

    private static Cliente criarCliente(Scanner scanner) {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();

        System.out.print("\nEndereço do Cliente: ");
        System.out.print("\nRua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Complemento: ");
        String complemento = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("País: ");
        String pais = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        Endereco endereco = new Endereco(rua, numero, complemento, bairro, cidade, estado, pais, cep);
        Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);

        return cliente;
    }

    private static Conta encontrarContaPorNumero(List<Conta> contas, String numeroAgencia, String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroAgencia().equals(numeroAgencia) && conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    private static void exibirInformacoesConta(Conta conta) {
        if (conta == null) {
            System.out.println("Nenhuma conta ativa. Selecione uma conta antes de prosseguir.");
            return;
        }

        System.out.println("\nInformações da Conta:");
        System.out.println("Número da Agência: " + conta.getNumeroAgencia());
        System.out.println("Número da Conta: " + conta.getNumeroConta());
        System.out.println("Saldo: R$" + conta.getSaldo());

        Cliente cliente = conta.getCliente();
        System.out.println("\nInformações do Cliente:");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCPF());
        System.out.println("Data de Nascimento: " + cliente.getDataNascimento());

        Endereco endereco = cliente.getEndereco();
        System.out.println("\nEndereço do Cliente:");
        System.out.println("Rua: " + endereco.getRua() + ", N°" + endereco.getNumero() + ", Complemento: " + endereco.getComplemento());
        System.out.println("Bairro: " + endereco.getBairro() + " - Cidade: " + endereco.getCidade() + " CEP: " + endereco.getCEP());
        System.out.println("Estado: " + endereco.getEstado() + " - País: " + endereco.getPais());
    }
}