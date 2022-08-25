package ex01;
import Cotacao_Dolar.Dolar;
import java.text.Format;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Ex01 {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Quanto em reais você quer comprar de doláres: R$");
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("$ #,###,###.##");
        double dolaresComprados = Dolar.buyDolar(scan.nextDouble());
        
        System.out.println("Você comprou " + df.format(dolaresComprados) + " dólares");
    }
    
}
