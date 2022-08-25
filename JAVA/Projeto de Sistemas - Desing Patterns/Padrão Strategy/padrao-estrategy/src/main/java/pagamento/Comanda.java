package pagamento;

import java.util.List;

public class Comanda {
    private Pagamento metodoDePagamento;

    private TipoPagamento tipoPagamento;
    private Double valorTotal;
    private List<Lanche> lanches;

    public Comanda(TipoPagamento tipoPagamento, List<Lanche> lanches) {
        if(tipoPagamento.getCodigo().equals(TipoPagamento.CARTAO_CREDITO))
        {
            metodoDePagamento = new PagamentoCartaoCredito();
            valorTotal = metodoDePagamento.pagar(valorTotal);
        }
        else if(tipoPagamento.getCodigo().equals(TipoPagamento.DINHEIRO))
        {
            metodoDePagamento = new PagamentoDinheiro();
            valorTotal = metodoDePagamento.pagar(valorTotal);
        }
        else if(tipoPagamento.getCodigo().equals(TipoPagamento.BOLETO))
        {
            metodoDePagamento = new PagamentoBoleto();
            valorTotal = metodoDePagamento.pagar(valorTotal);
        }
    }
}
