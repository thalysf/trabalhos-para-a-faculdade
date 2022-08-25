/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aspectos_fundamentais;

import java.io.*;
public class AspectosFundamentais06 {
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "";
        float nota1, nota2, media;
        DataInputStream dado;
        try
        {
            System.out.println("Entre com a nota 1");
            dado = new DataInputStream(System.in);
            s = dado.readLine();
            nota1 = Float.parseFloat(s);

            System.out.println("Entre com a nota 2");
            dado = new DataInputStream(System.in);
            s = dado.readLine();
            nota2= Float.parseFloat(s);

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
