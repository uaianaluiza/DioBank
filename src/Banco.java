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
        getContas().add(new Conta(request));
    }
}
