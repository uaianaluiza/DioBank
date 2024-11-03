public class ContaRequest {
    int agencia;
    int numero;
    double saldo;
    TipoConta tipoConta;
    Cliente cliente;

    public ContaRequest(int agencia, int numero, double saldo, TipoConta tipoConta, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
    }
}
