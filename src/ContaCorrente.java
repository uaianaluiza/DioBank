import java.util.List;
import java.util.Objects;

public class ContaCorrente extends Conta {

    public List<ContaCorrente> contasCorrente;

    public ContaCorrente(Integer agencia, Integer numero) {
        super(agencia, numero);
    }

    public ContaCorrente() {
        super();
    }

    public ContaCorrente(ContaRequest request) {
        super(request);
    }

    public ContaCorrente dadosContaCorrente(String cpf) {

        for (ContaCorrente conta : contasCorrente) {
            if (Objects.equals(conta.getCliente(cpf), cpf))
                return conta;
        }
        return null;
    }

}
