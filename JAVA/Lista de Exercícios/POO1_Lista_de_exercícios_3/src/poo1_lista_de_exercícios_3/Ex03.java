package poo1_lista_de_exercícios_3;
import java.io.*;
import java.util.Arrays;
public class Ex03 {

    public static void main(String[] args) throws IOException {
        int qtd;
        int[] numeros;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.print("Digite a quantidade de números a serem lidos: ");
                qtd = Integer.parseInt(dado.readLine());
            }while(qtd < 0);
            numeros = new int[qtd];
            int menor = 0, aux = 0;
            for(int i = 0; i < qtd; i++)
            {
                do{
                    System.out.print("Digite o número " + (i+1) + ": ");
                    numeros[i] = Integer.parseInt(dado.readLine());
                }while(numeros[i] < 0);
                if(aux == 0){
                     menor = numeros[i]; 
                     aux = 1;
                }
                if(numeros[i] < menor) menor = numeros[i];
            }
            System.out.println("Números digitados: " + Arrays.toString(numeros));
            System.out.println("Menor número digitado: " + menor);
            
            
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}