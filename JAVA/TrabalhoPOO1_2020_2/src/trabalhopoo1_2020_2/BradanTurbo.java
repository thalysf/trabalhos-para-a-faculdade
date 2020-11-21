package trabalhopoo1_2020_2;

public class BradanTurbo extends Sedan{
    public BradanTurbo(String cor) {
        super("BRSedanTurbo", "Bradan Turbo", cor, "Sedan", new Motor(true, 1000, 125));
    }

    @Override
    public void construir(Estoque estoque) throws FaltouInsumoException{
        Fabrica.produz(estoque, "Madeira", 20, this); // Madeira...
        Fabrica.produz(estoque, "Aço", 60, this); // Aço...
        Fabrica.produz(estoque, "Ferro", 300, this); // Ferro...
        Fabrica.produz(estoque, "Alumínio", 100, this); // Alumínio...
        Fabrica.produz(estoque, "Ouro", 10, this); // Ouro...
        Fabrica.produz(estoque, "Cobre", 50, this); // Cobre...
        Fabrica.produz(estoque, "Chumbo", 50, this); // Chumbo...
    }
}
