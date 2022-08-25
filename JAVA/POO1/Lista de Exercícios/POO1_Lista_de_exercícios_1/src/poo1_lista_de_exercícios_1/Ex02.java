package poo1_lista_de_exercícios_1;
import java.io.*;
/**
 *
 * @author thalys fabrete v06
 */
public class Ex02 {
    public static void main(String[] args) {
        // TODO code application logic here
        int result;
        int razao, primeiroTermo, qtdTermos;
        BufferedReader dado; 
        try
        {
            System.out.println("- Progressão Geométrica -");
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite o primeiro termo: ");
            primeiroTermo = Integer.parseInt(dado.readLine());
            
            System.out.print("Digite a razão: ");
            razao = Integer.parseInt(dado.readLine());
            
            
            System.out.print("Digite a quantidade de termos: ");
            qtdTermos = Integer.parseInt(dado.readLine());
            result = primeiroTermo * (int) Math.pow(razao, (qtdTermos - 1));
            System.out.println("Resultado: " + result);
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