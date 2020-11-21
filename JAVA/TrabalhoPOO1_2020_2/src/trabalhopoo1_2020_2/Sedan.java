package trabalhopoo1_2020_2;



public abstract class Sedan extends Carro{
    private static int qtdSedan = 0;

    public static int getQtdSedan() {
        return qtdSedan;
    }
 
    public Sedan(String codigo, String nome, String cor, String tipo, Motor motor) {
        super(codigo, nome, cor, tipo, motor);
        Sedan.qtdSedan++;
    }

  
}

