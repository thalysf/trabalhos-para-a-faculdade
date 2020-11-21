package trabalhopoo1_2020_2;

public class Bradan extends Sedan{
    public Bradan(String cor) {
        super("BRSedan", "Bradan", cor, "Sedan", new Motor(false, 1000, 65));
    }

    @Override
    public void construir(Estoque estoque) throws FaltouInsumoException{
        Fabrica.produz(estoque, "Ferro", 400, this); // Ferro...
        Fabrica.produz(estoque, "Alumínio", 60, this); // Alumínio...
        Fabrica.produz(estoque, "Cobre", 60, this); // Cobre...
        Fabrica.produz(estoque, "Chumbo", 50, this); // Chumbo...
    }
}
