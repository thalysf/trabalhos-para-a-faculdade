package trabalhopoo1_2020_2;

public abstract class Compacto extends Carro{
    private static int qtdCompacto = 0;
    public static int getQtdCompacto() {
        return qtdCompacto;
    }
    
    public Compacto(String codigo, String nome, String cor, String tipo, Motor motor) {
        super(codigo, nome, cor, tipo, motor);
        Compacto.qtdCompacto++;
    }
}
