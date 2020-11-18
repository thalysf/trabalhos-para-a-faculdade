/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo1_lista_de_exercícios_1;
import java.io.*;
/**
 *
 * @author thaly
 */
public class Ex04 {
     public static void main(String[] args) {
        double desconto;
        double valorProduto, valorDesconto, valorFinal;
        BufferedReader dado; 
        try
        {
            System.out.println("- Desconto de 9% -");
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite o valor do produto: ");
            valorProduto = Double.parseDouble(dado.readLine());
            do
            {
                System.out.print("Digite a porcentagem de desconto(0 a 100): ");
                desconto = Double.parseDouble(dado.readLine());
            }while(desconto > 100 || desconto < 0);
            
            valorDesconto = valorProduto * (desconto/100);
            valorFinal = valorProduto - valorDesconto;
            
            System.out.println("Valor original do protudo: " + valorProduto);
            System.out.println("Valor do desconto: "+ valorDesconto);
            System.out.println("Valor final: " + valorFinal);
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
