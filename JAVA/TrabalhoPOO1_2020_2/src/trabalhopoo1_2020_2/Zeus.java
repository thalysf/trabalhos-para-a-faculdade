package trabalhopoo1_2020_2;


public class Zeus extends Suv{
    public Zeus(String cor) {
        super("Zeus", "Zeus", cor, "SUV", new Motor(true, 2500, 280));
    }

    @Override
    public void construir(Estoque estoque) throws FaltouInsumoException{
        Fabrica.produz(estoque, "Madeira", 300, this); // Madeira...
        Fabrica.produz(estoque, "Aço", 800, this); // Aço...
        Fabrica.produz(estoque, "Alumínio", 600, this); // Alumínio...
        Fabrica.produz(estoque, "Ouro", 200, this); // Ouro...
    }
}
