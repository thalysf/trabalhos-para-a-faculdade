package Aplicacao;

import Entidades.Pessoa;
import Entidades.Juridica;
import Entidades.Fisica;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Lista... scan...
        LinkedList<Pessoa> pessoas = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        // variáveis...
        int i;
        char op;
        String nome;
        double totalDeImpostos = 0;
        Double renda;
        Double gastosComSaude;
        Integer numFuncionarios;
        System.out.print("Total de pessoas: ");
        i = scan.nextInt();
        for(; i > 0; i--)
        {
            System.out.print("F/J: ");
            op = scan.next().charAt(0);
            System.out.print("Nome: ");
            nome = scan.next();
            System.out.print("Renda: ");
            renda = scan.nextDouble();
            if(op == 'F' || op == 'f')
            {
                System.out.print("Gastos com saúde: ");
                gastosComSaude = scan.nextDouble();
                pessoas.add(new Fisica(gastosComSaude, nome, renda));
            }
            else if(op == 'J' || op == 'j')
            {
                System.out.print("Número de funcionários: ");
                numFuncionarios = scan.nextInt();
                pessoas.add(new Juridica(numFuncionarios, nome, renda));
            }
        }
        System.out.println();
        System.out.println("Impostos pagos: ");
        for(Pessoa pessoa : pessoas)
        {
            totalDeImpostos += pessoa.pagarImposto();
            System.out.println(pessoa.getNome() + " R$ " + pessoa.pagarImposto());
        }
        System.out.println("Total de impostos pagos: " + totalDeImpostos);
    }
    
}
