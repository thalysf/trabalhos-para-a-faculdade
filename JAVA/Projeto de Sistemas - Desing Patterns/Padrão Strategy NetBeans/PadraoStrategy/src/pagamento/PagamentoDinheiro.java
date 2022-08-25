package pagamento;

public class PagamentoDinheiro implements Pagamento{

    @Override
    public Double pagar(Double valor) {
        // Quando o pagamento é feito por dinheiro, haverá desconto de 5%
        return valor * 0.95;
    }
    
}
