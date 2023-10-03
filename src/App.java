import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Cadastro do cliente
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
    }
}
