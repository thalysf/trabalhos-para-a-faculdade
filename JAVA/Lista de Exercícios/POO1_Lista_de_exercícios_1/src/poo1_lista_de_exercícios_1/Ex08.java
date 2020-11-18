package poo1_lista_de_exercícios_1;
import java.io.*;
/**
 *
 * @author thaly
 */
public class Ex08 {
     public static void main(String[] args) throws IOException {
        float salarioMinimo, salarioPessoa;
        int qtdSalariosMinimos;
        BufferedReader dado; 
        try
        {
            System.out.println("- Quantidade de salários mínimos -");
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite o valor do salário mínimo: ");
            salarioMinimo = Float.parseFloat(dado.readLine());
            System.out.print("Digite o seu salário: ");
            salarioPessoa = Float.parseFloat(dado.readLine());
            qtdSalariosMinimos = (int)(salarioPessoa/salarioMinimo);
            System.out.println("A quantidade de salários mínimos que você recebe é: " + qtdSalariosMinimos);
        } 
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }     
    
     }
}