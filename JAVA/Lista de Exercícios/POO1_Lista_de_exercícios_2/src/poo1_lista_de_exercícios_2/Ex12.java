package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex12 {

    public static void main(String[] args) throws IOException {
        int[] notas;
        notas = new int[5];
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            
            for(int i = 0; i < 5; i++)
            {
                System.out.print("Digite a nota " + (i +1) + ": ");
                notas[i] = Integer.parseInt(dado.readLine());
            }
            int maior = notas[0], menor = notas[0];
            int menorPOS = 0, maiorPOS = 0, media = 0;
            for(int i = 0; i < 5; i++)
            {
                if(notas[i] > maior)
                {
                    maior = notas[i];
                    maiorPOS = i;
                }
                else if(notas[i] < menor)
                {
                    menor = notas[i];
                    menorPOS = i;
                }
            }
            for(int i = 0; i < 5; i++)
            {
                if(i != maiorPOS && i != menorPOS)
                {
                    media += notas[i];
                }
            }
            media = media/3;
            System.out.println("Média: " + media);
                
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}