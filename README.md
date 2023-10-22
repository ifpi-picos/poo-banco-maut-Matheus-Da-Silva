[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/INZ2UqYN)

# Instituto Federal do Piauí
- Curso Superior de Análise e Desenvolvimento de Sistemas - Módulo II
- Aluno: Matheus da Silva
- Professor: Jesiel Viana

Atividade da Disciplina de 'Programação Orientada à Objetos' para implementar um sistema bancário com o fito de usar e aprimorar os conceitos de POO na prática.

# Banco Maut
## -> Parte 1 (v1.0)

Nosso cliente, o Banco Maut,  solicitou um sistema financeiro para gestão de contas de seus clientes, por enquanto temos as seguintes informações (requisitos) sobre o sistema solicitado:
    
- Uma conta no banco Maut tem número da agência, número da conta, saldo e um Cliente vinculado;
- Para que um cliente abra uma conta no banco Maut, ele deve informar os seguintes dados: nome, CPF, data de nascimento e endereço completo;
- Uma conta só pode estar vinculada a um cliente, no entanto um cliente pode ter várias contas;
- O sistema deve possibilitar ao cliente ver o saldo de sua conta, depositar, sacar, transferir dinheiro para outra conta e exibir extrato (lista de transações realizadas);
- Após a criação da conta não pode-se alterar sua agência e nem seu número;
- O CPF do cliente não pode ser alterado;


## -> Parte 2

- O banco Maut solicitou que seu sistema permita aos clientes abrirem contas de dois tipos: corrente e poupança;
- A conta corrente pode ter cheque especial, que é um valor que o cliente pode sacar além do seu saldo;
- A conta corrente permite fazer até 2 transferências sem cobrar taxa (taxa de 10%);
- A conta poupança cobra uma taxa de 10% para cada transferência;
- A conta poupança cobra uma taxa de 5% do valor da transacão para cada saque realizado;
- A conta poupança tem um rendimento de 10% (porcentagem inicial quando a conta é criada, mas esse valor de rendimento pode variar) em cima do valor de cada depósito;
- Quando o cliente realizar alguma transação de alteração de saldo da conta o sistema deve enviar uma notificação via email ou sms;
