package trabalhopoo1_2020_2;


public class Gaia extends Sedan{
    public Gaia(String cor) {
        super("TitaSedan", "Gaia", cor, "Sedan", new Motor(true, 1500, 170));
    }

    @Override
    public void construir(Estoque estoque) throws FaltouInsumoException{
        Fabrica.produz(estoque, "Aço", 300, this); // Aço...
        Fabrica.produz(estoque, "Ferro", 250, this); // Ferro...
        Fabrica.produz(estoque, "Alumínio", 250, this); // Alumínio...
        Fabrica.produz(estoque, "Ouro", 5, this); // Ouro...
        Fabrica.produz(estoque, "Chumbo", 50, this); // Chumbo...
    }
}
