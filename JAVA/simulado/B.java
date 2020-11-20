package simulado;

public abstract class B extends Carro{
    private static int QtB = 0; // -> variável estática da classe
    public static int getQtB() { // método estático da classe
        return QtB;
    }
    // O Funcionamento desses métodos estáticos estáticos é algo que fica permanentemente guardadado na classe
    // Sem a necessidade de instanciar um objetos
    public B(double aceleracao, int velocidadeMaxima, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMaxima, dirigibilidade, propulsao);
        this.QtB++;
    }

   
}
