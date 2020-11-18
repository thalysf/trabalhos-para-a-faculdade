package poo1_lista_de_exercícios_1;
import java.io.*;
/**
 *
 * @author thaly
 */
public class Ex09 {
     public static void main(String[] args) throws IOException {
        double diaria = 60.00,  precoKm = 0.15, valorDoAluguel = 0;
        int dias, kmRodados;
        BufferedReader dado; 
        try
        {
            System.out.println("- Aluguel de carros -");
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite a quantidade de dias rodados com o carro: ");
            dias = Integer.parseInt(dado.readLine());
            System.out.print("Digite a quantidade de quilômetros rodados: ");
            kmRodados = Integer.parseInt(dado.readLine());
            valorDoAluguel = (dias * diaria) + (kmRodados * precoKm);
            System.out.println("O valor a pagar pelo aluguel do carro é: " + valorDoAluguel);
        } 
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }     
    
     }
}