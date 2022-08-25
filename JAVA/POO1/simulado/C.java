package simulado;

public abstract class C extends Carro{
    private static int QtC = 0; // -> variável estática da classe
    public static int getQtC() { // método estático da classe
        return QtC;
    }
    public C(double aceleracao, int velocidadeMaxima, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMaxima, dirigibilidade, propulsao);
        this.QtC++;
    }

}
