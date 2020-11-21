package trabalhopoo1_2020_2;

public class Hades extends Suv{
     public Hades(String cor) {
        super("Hades", "Hades", cor, "SUV", new Motor(true, 2000, 200));
    }

    @Override
    public void construir(Estoque estoque) throws FaltouInsumoException{
        Fabrica.produz(estoque, "Madeira", 100, this); // Madeira...
        Fabrica.produz(estoque, "Aço", 200, this); // Aço...
        Fabrica.produz(estoque, "Ferro", 400, this); // Ferro...
        Fabrica.produz(estoque, "Alumínio", 400, this); // Alumínio...
        Fabrica.produz(estoque, "Ouro", 100, this); // Ouro...
        Fabrica.produz(estoque, "Cobre", 50, this); // Cobre...
        Fabrica.produz(estoque, "Chumbo", 50, this); // Chumbo...
    }
}
