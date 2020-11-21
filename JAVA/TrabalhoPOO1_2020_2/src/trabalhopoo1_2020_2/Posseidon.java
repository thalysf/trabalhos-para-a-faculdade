package trabalhopoo1_2020_2;


public class Posseidon extends Suv{
    public Posseidon(String cor) {
        super("Posseidon", "Posseidon", cor, "SUV", new Motor(false, 2000, 180));
    }

    @Override
    public void construir(Estoque estoque) throws FaltouInsumoException{
        Fabrica.produz(estoque, "Madeira", 50, this); // Madeira...
        Fabrica.produz(estoque, "Aço", 100, this); // Aço...
        Fabrica.produz(estoque, "Ferro", 500, this); // Ferro...
        Fabrica.produz(estoque, "Alumínio", 200, this); // Alumínio...
        Fabrica.produz(estoque, "Ouro", 50, this); // Ouro...
        Fabrica.produz(estoque, "Cobre", 50, this); // Cobre...
    }
}
