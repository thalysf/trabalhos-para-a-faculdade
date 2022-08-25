package Ex01;
import java.io.*;
public class Main {

    
    public static void main(String[] args) throws IOException {
        double x1, x2, y1, y2, distancia;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            // Capturando valores do ponto 01
            System.out.print("Entre com o x1 do primeiro ponto: "); 
            x1 = Double.parseDouble(dado.readLine());
            System.out.print("Entre com o y1 do primeiro ponto: "); 
            y1 = Double.parseDouble(dado.readLine());
            // Capturando valores do ponto 02
            System.out.print("Entre com o x2 do segundo ponto: "); 
            x2 = Double.parseDouble(dado.readLine());
            System.out.print("Entre com o y2 do segundo ponto: "); 
            y2 = Double.parseDouble(dado.readLine());
            System.out.println(Distancia.calcularDistancia(x1, x2, y1, y2));  
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
    
}
