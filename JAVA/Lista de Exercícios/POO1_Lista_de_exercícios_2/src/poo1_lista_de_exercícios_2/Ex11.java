package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex11 {

    public static void main(String[] args) throws IOException {
        int mes;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite um mês: ");
            mes = Integer.parseInt(dado.readLine());
           switch(mes)
           {
               case 1: System.out.println("Janeiro"); break;
               case 2: System.out.println("Fevereiro"); break;
               case 3: System.out.println("Março"); break;
               case 4: System.out.println("Abril"); break;
               case 5: System.out.println("Maio"); break;
               case 6: System.out.println("Junho"); break;
               case 7: System.out.println("Julho"); break;
               case 8: System.out.println("Agosto"); break;
               case 9: System.out.println("Setembro"); break;
               case 10: System.out.println("Outubro"); break;
               case 11: System.out.println("Novembro"); break;
               case 12: System.out.println("Dezembro"); break;
               default: System.out.println("Não existe mês correspondente ao número digitado!");
               
           }
                
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}