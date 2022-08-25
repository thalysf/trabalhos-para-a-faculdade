package simulado;

public abstract class D extends Carro{
    private static int QtD = 0; // -> variável estática da classe
    public static int getQtD() { // método estático da classe
        return QtD;
    }
    public D(double aceleracao, int velocidadeMaxima, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMaxima, dirigibilidade, propulsao);
        this.QtD++;
    }
}
