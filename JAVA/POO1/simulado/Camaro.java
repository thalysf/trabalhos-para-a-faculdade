package simulado;

public class Camaro extends C{
    private static int preco = 110000;
    public Camaro(double aceleracao, int velocidadeMaxima, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMaxima, dirigibilidade, propulsao);
    }    

    @Override
    public int getPreco() {
        return Camaro.preco;
    }
}
