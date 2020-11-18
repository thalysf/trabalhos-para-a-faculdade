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
public class Ex03 {
     public static void main(String[] args) {
        double desconto = 0.09;
        double valorProduto, valorDesconto, valorFinal;
        BufferedReader dado; 
        try
        {
            System.out.println("- Desconto de 9% -");
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite o valor do produto: ");
            valorProduto = Double.parseDouble(dado.readLine());
            valorDesconto = valorProduto * desconto;
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
