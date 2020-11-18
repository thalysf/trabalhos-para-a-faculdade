package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex07 {

    public static void main(String[] args) throws IOException {
        float nota1, nota2, nota3;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite sua nota 01: ");
            nota1 = Integer.parseInt(dado.readLine());
            System.out.print("Digite sua nota 02: ");
            nota2 = Integer.parseInt(dado.readLine());
            System.out.print("Digite sua nota 03: ");
            nota3 = Integer.parseInt(dado.readLine());
            
            float media = (nota1 + nota2 + nota3)/3;
            System.out.println(media);
            if(media < 3)
            {
                System.out.println("Reprovado");
            }
            else if(media < 7)
            {
                System.out.println("Prova final");
            }
            else
            {
                System.out.println("Aprovado");
            }
            
                
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}