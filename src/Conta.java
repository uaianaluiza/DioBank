public class Conta {

    private Integer agencia;
    private Integer numero;
    private Double saldo;
    private Cliente cliente;

    public Conta(Integer agencia, Integer numero) {
        this.agencia = agencia;
        this.numero = numero;
    }

    public Conta(ContaRequest request) {
        this.agencia = request.agencia;
        this.numero = request.numero;
        this.saldo = request.saldo;
        this.cliente = request.cliente;
    }

    protected Conta() {
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Cliente getCliente(String cpf) {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double depositar(Double valor) {
        return saldo += valor;
    }

    public Double consultarSaldo() {
        return getSaldo();
    }

    public Double sacar(Double valor) {
        if (saldo < valor) {
            throw new RuntimeException("Saldo não possui valor suficiente");
        }
        return saldo -= valor;
    }

    public Double transferir(Double valor, Conta conta) {
        if (saldo < valor) {
            throw new RuntimeException("Saldo não possui valor suficiente");
        }else {
            this.sacar(valor);
            conta.depositar(valor);
            return consultarSaldo();
        }
    }
}
