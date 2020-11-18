package poo1_lista_de_exercícios_3;
import java.io.*;
public class Ex04 {

    public static void main(String[] args) throws IOException {
        int intervalorMenor, intervalorMaior;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.print("Digite o limite inferior do intervalo: ");
                intervalorMenor = Integer.parseInt(dado.readLine());
                System.out.print("Digite o limite superior do intervalo: ");
                intervalorMaior = Integer.parseInt(dado.readLine());
            }while(intervalorMenor >= intervalorMaior);
            System.out.println("Exibição dos número pares desse intervalo: ");
            for(int i = intervalorMenor + 1; i < intervalorMaior; i++)
            {
                if((i%2) == 0) System.out.println(i);
            }
            
            
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}