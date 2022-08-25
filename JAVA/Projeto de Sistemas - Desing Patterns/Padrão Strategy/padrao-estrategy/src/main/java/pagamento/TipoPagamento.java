package pagamento;

public enum TipoPagamento {
    CARTAO_CREDITO("C"), DINHEIRO("D"), BOLETO("B");

    protected final String codigo;

    TipoPagamento(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
