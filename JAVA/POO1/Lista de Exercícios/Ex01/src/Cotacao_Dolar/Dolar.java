package Cotacao_Dolar;

public class Dolar {
    private static final double COTACAODOLAR = 5.32;
    
    public static double buyDolar(double real)
    {
        return real / Dolar.COTACAODOLAR;
    }
}
