/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aspectos_fundamentais;
import java.io.*;
public class AspectosFundamentais07 {
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "";
        float nota1, nota2, media;
        BufferedReader dado; // Classe alterada
        try
        {
            System.out.println("Entre com a nota 1");
            dado = new BufferedReader(new InputStreamReader(System.in));
            s = dado.readLine();
            nota1 = Float.parseFloat(s);

            System.out.println("Entre com a nota 2");
            dado = new BufferedReader(new InputStreamReader(System.in));
            nota2= Float.parseFloat(dado.readLine()); // chamada do método readLine()

            media = ( nota1 + nota2 ) / 2;
            System.out.println("Media: " + media);
        } 
        catch (IOException erro)
        {
            System.out.println("Erro na entrada de dados");
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }        
    }
}
