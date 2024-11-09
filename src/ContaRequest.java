public class ContaRequest {
    int agencia;
    int numero;
    double saldo = 0;
    Cliente cliente;
    int tipoConta;

    public ContaRequest(int agencia, int numero, Cliente cliente, int tipoConta) {
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
    }
}
