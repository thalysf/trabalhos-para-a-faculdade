package poo1_lista_de_exercícios_2;
import java.io.*;
public class Ex13 {

    public static void main(String[] args) throws IOException {
        int codProduto, precoUni, quantidade;
        float porcentoDesconto, valorFinal, valorDesconto, valorTotal;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            do
            {
                System.out.print("Digite o código do produto: ");
                codProduto = Integer.parseInt(dado.readLine());
                System.out.print("Digite a quantidade desejada: ");
                quantidade = Integer.parseInt(dado.readLine());
            }while(codProduto < 0 || codProduto > 40 || quantidade < 0);
            
            if(codProduto <= 10) precoUni = 10;
            else if(codProduto <= 20) precoUni = 15;
            else if(codProduto <= 30) precoUni = 20;
            else precoUni = 30;
            
               
            valorTotal = precoUni * quantidade;
            
            if(valorTotal <= 250) porcentoDesconto = (float) 0.05;
            else if(valorTotal < 500) porcentoDesconto = (float) 0.10;
            else porcentoDesconto = (float) 0.15;
            
            valorDesconto = valorTotal - (valorTotal * porcentoDesconto);
            valorFinal = valorTotal - valorDesconto;
            System.out.println("Preço unitário: R$ " + precoUni + ",00");
            System.out.println("Valor total: R$ " + valorTotal + ",00");
            System.out.println("Valor do desconto: R$ " + valorDesconto + ",00");
            System.out.println("Valor do final: R$ " + valorFinal + ",00");
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}