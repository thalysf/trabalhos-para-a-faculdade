package pagamento;

public class PagamentoCartaoCredito implements Pagamento{

    @Override
    public Double pagar(Double valor) {
        // Quando o pagamento é feito por cartão de crédito, haverá juros de 5%
        return valor * 1.05;
    }
}
