package simulado;

public class Survolt extends B{
    private static int preco = 150000;
    public Survolt(double aceleracao, int velocidadeMaxima, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMaxima, dirigibilidade, propulsao);
    } 

    @Override
    public int getPreco() {
        return Survolt.preco;
    }
}
