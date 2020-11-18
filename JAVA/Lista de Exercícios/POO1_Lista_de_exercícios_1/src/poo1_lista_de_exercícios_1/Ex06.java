package poo1_lista_de_exercícios_1;
import java.io.*;
/**
 *
 * @author thaly
 */
public class Ex06 {
     public static void main(String[] args) throws IOException {
        double grausCentigrados, fahrenheit;
        BufferedReader dado; 
        try
        {
            System.out.println("- fahrenheit para Celsius-");
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite a temperatura fahrenheit: ");
            fahrenheit = Double.parseDouble(dado.readLine());
            
            grausCentigrados = (fahrenheit - 32) * 5/9;
            System.out.println(fahrenheit + " Fahrenheit equivalem a " + grausCentigrados + " Graus centígrados");
         
        } 
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }     
    
     }
}