package pagamento;

public class PagamentoBoleto implements Pagamento{

    @Override
    public Double pagar(Double valor) {
        // Quando o pagamento é feito por boleto o valor permanece o mesmo
        return valor;
    }
}
