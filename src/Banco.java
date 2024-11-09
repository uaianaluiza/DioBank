import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Banco {

    public List<Conta> contas;
    public List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return new ArrayList<>();
    }

    public List<Conta> getContas() {
        return new ArrayList<>();
    }

    public Cliente buscarCliente(String cpf) {

        for (Cliente cliente : getClientes()) {
            if (Objects.equals(cliente.getCpf(), cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void cadastrarCliente(String nome, String cpf) {
        getClientes().add(new Cliente(nome, cpf));
    }

    public void cadastrarConta(ContaRequest request) {
        int tipodeConta = request.tipoConta;

        switch (tipodeConta) {
            case 1 -> getContas().add(new ContaCorrente(request));
            case 2 -> getContas().add(new ContaPoupanca(request));
            default -> System.out.println("Opção inválida, selecione 1 para Conta Corrente ou dois para Conta Poupança");
        }
    }

}
