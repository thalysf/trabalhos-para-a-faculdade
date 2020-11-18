package poo1_lista_de_exercícios_3;
import java.io.*;
public class Ex05 {

    public static void main(String[] args) throws IOException {
        int n, fat;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.print("Digite o fatorial desejado: ");
                n = Integer.parseInt(dado.readLine());
            }while(n < 0);
            System.out.println("O fatorial de " + n + " é igual a " + fatorial(n));
            
            
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }

    public static int fatorial(int n)
    {
        if(n == 1) return 1;
        return n * fatorial(n-1);
    }
}