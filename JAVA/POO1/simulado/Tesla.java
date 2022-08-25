package simulado;

public class Tesla extends D{
    private static int preco = 60000;
    public Tesla(double aceleracao, int velocidadeMaxima, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMaxima, dirigibilidade, propulsao);
    }    

    @Override
    public int getPreco() {
        return Tesla.preco;
    }
}
