import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    ContaCorrente contaCorrente = new ContaCorrente();
    ContaPoupanca contaPoupanca = new ContaPoupanca();

    public Conta informeOsDadosDaConta() {
        System.out.println("Informe o número da agencia");
        int agencia = scanner.nextInt();
        System.out.println("Informe o número da conta");
        int numero = scanner.nextInt();
        return new Conta(agencia, numero);
    }

    public void acessarMenu() {

        System.out.println("Bem-vindo(a) ao DioBank");
        System.out.println("Informe o tipo de acesso: ");
        System.out.println("1 -> Cliente");
        System.out.println("2 -> Funcionário");

        int tipoAcesso = scanner.nextInt();

        if (tipoAcesso == 1) {
            menuCliente();
        } else if (tipoAcesso == 2) {
            menuFuncionario();
        } else {
            throw new RuntimeException("Opção inválida");
        }
    }

    private void menuCliente() {

        Conta conta = informeOsDadosDaConta();

        System.out.println(" 1 -> Saque");
        System.out.println(" 2 -> Depósito");
        System.out.println(" 3 -> Transferencia");
        System.out.println(" 4 -> Consultar Saldo");
        System.out.println(" 5 -> Consultar Dados da conta");

        int escolha = scanner.nextInt();

        switch (escolha) {

            case 1 -> {
                System.out.println("Informe o valor do saque");
                double valor = scanner.nextDouble();
                conta.sacar(valor);
                System.out.println("Saque realizado. Saldo atual: " + conta.consultarSaldo());
                menuCliente();
            }
            case 2 -> {
                System.out.println("Informe o valor do depósito");
                double valor = scanner.nextDouble();
                conta.depositar(valor);
                System.out.println("Depósito realizado. Saldo atual: " + conta.consultarSaldo());
                menuCliente();
            }
            case 3 -> {
                System.out.println("Informe os dados da conta destino (Número da conta e agência):");
                Conta contaDestino = informeOsDadosDaConta();
                System.out.println("Informe o valor da transferência:");
                double valor = scanner.nextDouble();
                conta.transferir(valor, contaDestino);
                System.out.println("Transferência realizada. Saldo atual: " + conta.consultarSaldo());
                menuCliente();
            }
            case 4 -> {
                System.out.println("Saldo atual: " + conta.consultarSaldo());
                menuCliente();
            }
            case 5 -> {
                System.out.println("Informe o tipo de conta: 1-Conta Corrente ou 2-Conta Poupança");
                int tipoConta = scanner.nextInt();
                System.out.println("Informe o cpf do cliente");
                String cpf = scanner.next();
                if (tipoConta == 1) {
                    contaCorrente.dadosContaCorrente(cpf);
                } else if (tipoConta == 2) {
                    contaPoupanca.dadosContaPoupanca(cpf);
                } else System.out.println("Tipo de conta inválido");
            }

            default -> {
                System.out.println("Opção inválida.");
                menuCliente();
            }
        }
    }

    private void menuFuncionario() {

        Banco banco = new Banco();

        System.out.println(" 1 -> Cadastrar Cliente");
        System.out.println(" 2 -> Cadastrar Conta");
        System.out.println(" 3 -> Saque");
        System.out.println(" 4 -> Depósito");
        System.out.println(" 5 -> Transferencia");
        System.out.println(" 6 -> Consultar Saldo");
        System.out.println(" 7 -> Listar Contas");
        System.out.println(" 8 -> Listar Clientes");
        System.out.println(" 9 -> Consultar Dados da conta");

        int escolhaFuncionario = scanner.nextInt();

        switch (escolhaFuncionario) {

            case 1 -> {
                System.out.println("Informe o nome do cliente:");
                String nome = scanner.next();
                System.out.println("Informe o CPF do cliente:");
                String cpf = scanner.next();
                banco.cadastrarCliente(nome, cpf);
                System.out.println("Cliente cadastrado com sucesso.");
                menuFuncionario();
            }
            case 2 -> {
                System.out.println("Informe o CPF do cliente:");
                String cpf = scanner.next();
                Cliente cliente = banco.buscarCliente(cpf);
                if (cliente != null) {
                    System.out.println("Informe o número da agencia");
                    int agencia = scanner.nextInt();
                    System.out.println("Informe o número da conta");
                    int numero = scanner.nextInt();
                    System.out.println("Informe o tipo de conta:  1-Conta Corrente ou 2-Conta Poupança");
                    int tipoConta = scanner.nextInt();
                    ContaRequest request = new ContaRequest(agencia, numero, cliente, tipoConta);
                    banco.cadastrarConta(request);
                    System.out.println("Conta cadastrada com sucesso.");
                    menuFuncionario();
                } else {
                    System.out.println("Cliente não encontrado. Retorne ao menu e cadastre o cliente");
                    menuFuncionario();
                }
            }

            case 3 -> {
                Conta conta = informeOsDadosDaConta();
                System.out.println("Informe o valor do saque:");
                double valor = scanner.nextDouble();
                conta.sacar(valor);
                System.out.println("Saque realizado. Saldo atual: " + conta.consultarSaldo());
                menuFuncionario();
            }

            case 4 -> {
                Conta conta = informeOsDadosDaConta();
                System.out.println("Informe o valor do depósito:");
                double valor = scanner.nextDouble();
                conta.depositar(valor);
                System.out.println("Depósito realizado. Saldo atual: " + conta.consultarSaldo());
                menuFuncionario();
            }
            case 5 -> {
                Conta conta = informeOsDadosDaConta();
                System.out.println("Informe os dados da conta destino:");
                Conta contaDestino = informeOsDadosDaConta();

                System.out.println("Informe o valor da transferência:");
                double valor = scanner.nextDouble();
                conta.transferir(valor, contaDestino);
                System.out.println("Transferência realizada. Saldo atual: " + conta.consultarSaldo());
                menuFuncionario();
            }
            case 6 -> {
                Conta conta = informeOsDadosDaConta();
                System.out.println("Saldo atual: " + conta.consultarSaldo());
                menuFuncionario();
            }
            case 7 -> {
                System.out.println("Listando todas as contas:");
                banco.getContas().forEach(System.out::println);
                menuFuncionario();
            }
            case 8 -> {
                System.out.println("Listando todos os clientes:");
                banco.getClientes().forEach(System.out::println);
                menuFuncionario();
            }
            case 9 -> {
                System.out.println("Informe o tipo de conta: 1-Conta Corrente ou 2-Conta Poupança");
                int tipoConta = scanner.nextInt();
                System.out.println("Informe o cpf do cliente");
                String cpf = scanner.next();
                if (tipoConta == 1) {
                    contaCorrente.dadosContaCorrente(cpf);
                } else if (tipoConta == 2) {
                    contaPoupanca.dadosContaPoupanca(cpf);
                } else System.out.println("Tipo de conta inválido");
            }
            default -> {
                System.out.println("Opção inválida");
                menuFuncionario();
            }
        }
    }
}


