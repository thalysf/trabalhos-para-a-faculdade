package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex08 {

    public static void main(String[] args) throws IOException {
        int x;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite o valor de x: ");
            x = Integer.parseInt(dado.readLine());
            if(x < 2)
            {
                System.out.println("1");
            }
            else if(x < 3)
            {
                System.out.println("2");
            }
            else if(x < 4)
            {
                System.out.println(Math.pow(x, 2));
            }
            else{
                System.out.println(Math.pow(x, 3));
            }
            
                
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}