package poo1_lista_de_exercícios_1;
import java.io.*;
/**
 *
 * @author thaly
 */
public class Ex05 {
     public static void main(String[] args) throws IOException {
        double grausCentigrados, fahrenheit;
        BufferedReader dado; 
        try
        {
            System.out.println("- Graus para Fahrenheit-");
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite a temperatura em graus centígrados: ");
            grausCentigrados = Double.parseDouble(dado.readLine());
            
            fahrenheit = (9 * grausCentigrados + 160)/5;
            System.out.println(grausCentigrados + " Graus Centígraos equivalem a " + fahrenheit + " Fahrenheit");
         
        } 
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }     
    
     }
}