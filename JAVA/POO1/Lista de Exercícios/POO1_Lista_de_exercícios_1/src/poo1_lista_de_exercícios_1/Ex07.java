package poo1_lista_de_exercícios_1;
import java.io.*;
/**
 *
 * @author thaly
 */
public class Ex07 {
     public static void main(String[] args) throws IOException {
        int a, b;
        BufferedReader dado; 
        try
        {
            System.out.println("- Troca de A para B e vice versa-");
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite o valor de A: ");
            a = Integer.parseInt(dado.readLine());
            System.out.print("Digite o valor de B: ");
            b = Integer.parseInt(dado.readLine());
            int aux = b;
            b = a;
            a = aux;
            System.out.println("Valores invetidos: ");
            System.out.print("A: " + a);
            System.out.println(" | B: " + b);
        } 
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }     
    
     }
}