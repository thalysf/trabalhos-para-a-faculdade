package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex03 {

    public static void main(String[] args) throws IOException {
        int a, b, c;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite o valor de A: ");
            a = Integer.parseInt(dado.readLine());
            System.out.print("Digite o valor de B: ");
            b = Integer.parseInt(dado.readLine());
            System.out.print("Digite o valor de C: ");
            c = Integer.parseInt(dado.readLine());
            if(a > b && a > c)
            {
                if(b > c)
                {
                    System.out.println(a + " > " + b + " > " + c);
                }
                else
                {
                System.out.println(a + " > " + c +" > " + b);
                }
            }
            else
            {
                if(b > c && c > a)
                {
                    System.out.println(b + " > " + c + " > " + a);
                }
                if(a > c && b > a)
                {
                    System.out.println(b + " > " + a + " > " + c);
                }
                    
                if(c > b && b > a)
                {
                    System.out.println(c + " > " + b + " > " + a);
                }
                if(c > a && a > b)
                {
                    System.out.println(c + " > " + a + " > " + b);
                }
            }
            
            
                
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
    
}