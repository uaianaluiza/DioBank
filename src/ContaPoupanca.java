import java.util.List;
import java.util.Objects;

public class ContaPoupanca extends Conta {

    public List<ContaPoupanca> contasPoupanca;

    public ContaPoupanca(Integer agencia, Integer numero) {
        super(agencia, numero);
    }

    public ContaPoupanca(ContaRequest request) {
        super(request);
    }

    public ContaPoupanca() {
    }

    public ContaPoupanca dadosContaPoupanca(String cpf) {

        for (ContaPoupanca conta : contasPoupanca) {
            if (Objects.equals(conta.getCliente(cpf), cpf))
                return conta;
        }
        return null;
    }

}
