package poo1_lista_de_exercícios_3;
import java.io.*;
public class Ex06 {

    public static void main(String[] args) throws IOException {
        int nEsimo;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.print("Digite o N-ésimo número: ");
                nEsimo = Integer.parseInt(dado.readLine());
            }while(nEsimo < 0);
           
            for(int i = 1; i <= nEsimo; i++)
            {
                System.out.println(Math.pow(i, 2));
            }
            
            
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}