package pagamento;

import java.util.List;

public class Comanda {
    private Pagamento pagamento;

    private TipoPagamento tipoPagamento;
    private Double valorTotal;
    private List<Lanche> lanches;

    public Comanda(TipoPagamento tipoPagamento, List<Lanche> lanches) {
        this.valorTotal = 0d;
        calcularValorTotalLanches(lanches);
        this.atualizarPagamento(tipoPagamento);
        this.lanches = lanches;
    }

    private void calcularValorTotalLanches(List<Lanche> lanches)
    {
        for (Lanche lanche : lanches) {
            this.valorTotal += lanche.getPreco();
        }
    }

    public void atualizarPagamento(TipoPagamento tipoPagamento){
        if(TipoPagamento.CARTAO_CREDITO.equals(tipoPagamento))
        {
            pagamento = new PagamentoCartaoCredito();
            this.valorTotal = pagamento.pagar(this.valorTotal);
        }
        else if(TipoPagamento.DINHEIRO.equals(tipoPagamento))
        {
            pagamento = new PagamentoDinheiro();
            this.valorTotal = pagamento.pagar(this.valorTotal);
        }
        else if(TipoPagamento.BOLETO.equals(tipoPagamento))
        {
            pagamento = new PagamentoBoleto();
            this.valorTotal = pagamento.pagar(this.valorTotal);
        }
        this.tipoPagamento = tipoPagamento;
    }


    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Lanche> getLanches() {
        return lanches;
    }

    public void setLanches(List<Lanche> lanches) {
        this.lanches = lanches;
    }
}
