package trabalhopoo1_2020_2;

/**
 *
 * @author thaly
 */
public abstract class Suv extends Carro{
    private static int qtdSuv = 0;

    public static int getQtdSuv() {
        return qtdSuv;
    }
    
    public Suv(String codigo, String nome, String cor, String tipo, Motor motor) {
        super(codigo, nome, cor, tipo, motor);
        Suv.qtdSuv++;
    }
    
}
