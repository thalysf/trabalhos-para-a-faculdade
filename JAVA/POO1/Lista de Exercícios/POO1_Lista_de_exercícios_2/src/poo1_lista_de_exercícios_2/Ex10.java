package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex10 {

    public static void main(String[] args) throws IOException {
        int dia;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite um dia da semana: ");
            dia = Integer.parseInt(dado.readLine());
           switch(dia)
           {
               case 1: System.out.println("Segunda"); break;
               case 2: System.out.println("Terça"); break;
               case 3: System.out.println("Quarta"); break;
               case 4: System.out.println("Quinta"); break;
               case 5: System.out.println("Sexta"); break;
               case 6: System.out.println("Sábado"); break;
               case 7: System.out.println("Domingo"); break;
               default: System.out.println("Dia da semana não corresponde ao número digitado!");
               
           }
                
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}