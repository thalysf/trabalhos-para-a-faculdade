package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex09 {

    public static void main(String[] args) throws IOException {
        int a, b, c, delta;
        float x1, x2;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite o valor de a: ");
            a = Integer.parseInt(dado.readLine());
            System.out.print("Digite o valor de b: ");
            b = Integer.parseInt(dado.readLine());
            System.out.print("Digite o valor de c: ");
            c = Integer.parseInt(dado.readLine());
            delta = (int) Math.pow(b, 2) - (4 * a * c);
            System.out.println("Delta = " + delta);
            if(delta < 0)
            {
                System.out.println("Equação do segundo grau sem raízes reais!");
            }
            else if(delta == 0)
            {
                x1 = -(b)/ (2 *a);
                System.out.println("Equação com apenas uma raiz de valor: " + x1);
            }
            else
            {
                System.out.println("Equação com duas raízes reais e distintas: ");
                x1 = (float) ((-b + Math.sqrt(delta))/ (2*a));
                x2 =   (float) ((-b - Math.sqrt(delta))/ (2*a));
                System.out.println("x1 = " + x1 + " | " + "x2 = " +  x2);
            }
                
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}