import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

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

        System.out.println("Informe os dados da Conta");
        Conta conta = new Conta(scanner.nextInt(), scanner.nextInt());

        System.out.println(" 1 -> Saque");
        System.out.println(" 2 -> Depósito");
        System.out.println(" 3 -> Transferencia");
        System.out.println(" 4 -> Consultar Saldo");

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
                Conta contaDestino = new Conta(scanner.nextInt(), scanner.nextInt());
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
                    System.out.println("Informe o número da conta, agência e saldo inicial:");
                    ContaRequest request = new ContaRequest(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble(), TipoConta.valueOf(scanner.next()), cliente);
                    banco.cadastrarConta(request);
                    System.out.println("Conta cadastrada com sucesso.");
                    menuFuncionario();
                } else {
                    System.out.println("Cliente não encontrado.");
                    menuFuncionario();
                }
            }

            case 3 -> {
                System.out.println("Informe os dados da Conta (Número da conta e agência):");
                Conta conta = new Conta(scanner.nextInt(), scanner.nextInt());
                System.out.println("Informe o valor do saque:");
                double valor = scanner.nextDouble();
                conta.sacar(valor);
                System.out.println("Saque realizado. Saldo atual: " + conta.consultarSaldo());
                menuFuncionario();
            }

            case 4 -> {
                System.out.println("Informe os dados da Conta (Número da conta e agência):");
                Conta conta = new Conta(scanner.nextInt(), scanner.nextInt());
                System.out.println("Informe o valor do depósito:");
                double valor = scanner.nextDouble();
                conta.depositar(valor);
                System.out.println("Depósito realizado. Saldo atual: " + conta.consultarSaldo());
                menuFuncionario();
            }
            case 5 -> {
                System.out.println("Informe os dados da Conta (Número da conta e agência):");
                Conta conta = new Conta(scanner.nextInt(), scanner.nextInt());
                System.out.println("Informe os dados da conta destino (Número da conta e agência):");
                Conta contaDestino = new Conta(scanner.nextInt(), scanner.nextInt());
                System.out.println("Informe o valor da transferência:");
                double valor = scanner.nextDouble();
                conta.transferir(valor, contaDestino);
                System.out.println("Transferência realizada. Saldo atual: " + conta.consultarSaldo());
                menuFuncionario();
            }
            case 6 -> {
                System.out.println("Informe os dados da Conta (Número da conta e agência):");
                Conta conta = new Conta(scanner.nextInt(), scanner.nextInt());
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
            default -> {
                System.out.println("Opção inválida");
                menuFuncionario();
            }
        }
    }
}


