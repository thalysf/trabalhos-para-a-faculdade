package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex05 {

    public static void main(String[] args) throws IOException {
        int idade;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite sua idade: ");
            idade = Integer.parseInt(dado.readLine());
          
            if(idade  < 18)
            {
                System.out.println("Menor de idade");
            }
            else if(idade < 65)
            {
                System.out.println("Maior de idade");
            }
            else
            {
                System.out.println("Idoso(a)");
            }
            
            
                
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
    
}