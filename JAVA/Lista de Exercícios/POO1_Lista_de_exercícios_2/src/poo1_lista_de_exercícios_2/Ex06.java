package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex06 {

    public static void main(String[] args) throws IOException {
        int idade;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite sua idade: ");
            idade = Integer.parseInt(dado.readLine());
            if(idade  < 16)
            {
                System.out.println("Não eleitor");
            }
            else if(idade < 18)
            {
                System.out.println("Eleitor Facultativo");
            }
            else if(idade < 65)
            {
                System.out.println("Eleitor obrigatório");
            }
            else
            {
                System.out.println("Eleitor Facultativo");
            }
            
            
                
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
    
}