package trabalhopoo1_2020_2;

public class Motor {

    public Motor(boolean turbo, int cilindrada, int qtdCavalos) {
        this.turbo = turbo;
        this.cilindrada = cilindrada;
        this.qtdCavalos = qtdCavalos;
    }
    private boolean turbo;
    private int cilindrada;
    private int qtdCavalos;

    public boolean isTurbo() {
        return turbo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public int getQtdCavalos() {
        return qtdCavalos;
    }

    @Override
    public String toString() {
        return "Motor{" + "turbo=" + turbo + ", cilindrada=" + cilindrada + ", qtdCavalos=" + qtdCavalos + '}';
    }
    
}
