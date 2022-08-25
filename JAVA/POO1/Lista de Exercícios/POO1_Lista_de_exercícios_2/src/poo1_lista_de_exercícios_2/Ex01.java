package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex01 {

    public static void main(String[] args) throws IOException {
        int n1, n2;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite o primeiro número: ");
            n1 = Integer.parseInt(dado.readLine());
            System.out.print("Digite o segundo número: ");
            n2 = Integer.parseInt(dado.readLine());
            
            if((n1 + n2) > 20)
            {
                System.out.println("Soma maior que 20, portanto resultado alterado para + 8: " + ((n1 + n2) + 8));
            }
            else
            {
                System.out.println("Soma inferior a 20, portanto resultado alterado para -5: " + ((n1 + n2) - 5));
            }
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
    
}
