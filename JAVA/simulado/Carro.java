package simulado;

public abstract class Carro {
    private double aceleracao;
    private int velocidadeMaxima;
    private double dirigibilidade;
    private int propulsao;

    public Carro(double aceleracao, int velocidadeMaxima, double dirigibilidade, int propulsao) {
        this.aceleracao = aceleracao;
        this.velocidadeMaxima = velocidadeMaxima;
        this.dirigibilidade = dirigibilidade;
        this.propulsao = propulsao;
    }
    public abstract int getPreco();

    @Override
    public String toString() {
        return "Aceleração = " + aceleracao + ", Velocidade Máxima = " + velocidadeMaxima + ", Dirigibilidade = " + dirigibilidade + ", Propulsão = " + propulsao + ".";
    }
}
