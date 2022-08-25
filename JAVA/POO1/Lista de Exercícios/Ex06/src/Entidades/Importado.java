package Entidades;

public class Importado extends Produto{
    private Double custosDeImportacao;

    public Importado(Double custosDeImportacao, String nome, Double preco) {
        super(nome, preco);
        this.custosDeImportacao = custosDeImportacao;
    }

    public Double getCustosDeImportacao() {
        return custosDeImportacao;
    }

    public void setCustosDeImportacao(Double custosDeImportacao) {
        this.custosDeImportacao = custosDeImportacao;
    }
    @Override
    public String etiquetaDePreco()
    {
        setPreco(getPreco() + custosDeImportacao);
        return super.etiquetaDePreco() + "(Custos de importação: R$"  + custosDeImportacao;
    }
}
