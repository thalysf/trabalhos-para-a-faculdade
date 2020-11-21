package trabalhopoo1_2020_2;

public class Brazuca extends Compacto{

    public Brazuca(String cor) {
        super("BR1.0", "Brazuca", cor, "Compacto", new Motor(false, 1000, 65));
    }

    @Override
    public void construir(Estoque estoque) throws FaltouInsumoException{
        Fabrica.produz(estoque, "Ferro", 300, this); // Ferro...
        Fabrica.produz(estoque, "Alumínio", 50, this); // Alumínio...
        Fabrica.produz(estoque, "Cobre", 50, this); // Cobre...
        Fabrica.produz(estoque, "Chumbo", 50, this); // Chumbo...
    }
    
}
