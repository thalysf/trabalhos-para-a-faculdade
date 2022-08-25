package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex04 {

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite um número: ");
            n = Integer.parseInt(dado.readLine());
          
            if((n % 10 == 0) || (n % 5 == 0) || (n % 2 == 0))
            {
                System.out.println("Divisível");
            }
            else
            {
                System.out.println("Não Divisível");
            }
            
            
                
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
    
}