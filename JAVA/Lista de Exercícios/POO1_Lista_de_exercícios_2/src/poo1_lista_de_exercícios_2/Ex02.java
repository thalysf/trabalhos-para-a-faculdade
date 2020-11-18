package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex02 {

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite um número: ");
            n = Integer.parseInt(dado.readLine());
            
            if(n >= 0)
            {
                System.out.println("Raiz do número " + n + " = " + Math.sqrt(n));
            }
            else
            {
                System.out.println("Quadrado do número " + n + " = " + Math.pow(n, 2));
            }
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
    
}