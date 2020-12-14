package Aplicacao;

import Entidades.Importado;
import Entidades.Produto;
import Entidades.Usado;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class App {

    public static void main(String[] args) throws ParseException {
        // Criando lista de Produtos e definindo modelo de data
        LinkedList<Produto> produtos = new LinkedList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // Variáveis...
        String tipoProd;
        String nome;
        Date dataManofatura;
        int i;
        Double preco;
        Double custoImportacao;
        // Scanner...
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o número de produtos: ");
        i = scan.nextInt();
        System.out.println("\n");
        while(i > 0)
        {
            System.out.print("Comum, Usado, Importado (C/U/I): ");
            tipoProd = scan.next();
            System.out.print("Nome: ");
            nome = scan.next();
            System.out.print("Preço: ");
            preco = scan.nextDouble();
            if("U".equals(tipoProd))
            {
                System.out.print("Data da manofatura(dd/MM/yyyy): ");
                dataManofatura = dateFormat.parse(scan.next());
                produtos.add(new Usado(nome, preco, dataManofatura));
            }
            else if("I".equals(tipoProd))
            {
                System.out.print("Custos da importação: ");
                custoImportacao = scan.nextDouble();
                produtos.add(new Importado(custoImportacao, nome, preco));
            }
            else
            {
                produtos.add(new Produto(nome, preco));
            }
            System.out.println("\n");
            i--;
        }
        
        System.out.println("Pagamentos: ");
        Iterator it = produtos.iterator();
        while(it.hasNext())
        {
            Produto atualProd = (Produto) it.next();
            System.out.println(atualProd.etiquetaDePreco());
        }
    }
    
}
