package trabalhopoo1_2020_2;

public class FaltouInsumoException extends Exception{
    protected String CodCarroNaoFabricado;
    protected String CorCarroNaoFabricado;
    protected String insumoFaltante;

    public FaltouInsumoException(String CodCarroNaoFabricado, String CorCarroNaoFabricado, String insumoFaltante) {
        this.CodCarroNaoFabricado = CodCarroNaoFabricado;
        this.CorCarroNaoFabricado = CorCarroNaoFabricado;
        this.insumoFaltante = insumoFaltante;
    }

    @Override
    public String getMessage() {
        return CodCarroNaoFabricado + " - " + CorCarroNaoFabricado + " - " + insumoFaltante;
    }
}
