package Aplicacao;

import Entidades.Funcionario;
import Entidades.Terceirizado;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

    
    public static void main(String[] args) {
        // Criando lista de funcionários
        LinkedList<Funcionario> funcionarios = new LinkedList<>();
        // Variáveis...
        String ehTerceirizado;
        String nome;
        int horas;
        int i;
        Double valorPorHora;
        Double despesaAdd;
        // Scanner...
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o número de funcionários: ");
        i = scan.nextInt();
        System.out.println("\n");
        while(i > 0)
        {
            System.out.print("Terceirizado (S/N): ");
            ehTerceirizado = scan.next();
            System.out.print("Nome: ");
            nome = scan.next();
            System.out.print("Horas: ");
            horas = scan.nextInt();
            System.out.print("Valor por hora: ");
            valorPorHora = scan.nextDouble();
            if("S".equals(ehTerceirizado))
            {
                System.out.print("Despesa adicional: ");
                despesaAdd = scan.nextDouble();
                funcionarios.add(new Terceirizado(despesaAdd, nome, horas, valorPorHora));
            }
            else
            {
                funcionarios.add(new Funcionario(nome, horas, valorPorHora));
            }
            System.out.println("\n");
            i--;
        }
        
        System.out.println("Pagamentos: ");
        Iterator it = funcionarios.iterator();
        while(it.hasNext())
        {
            Funcionario atualFunc = (Funcionario) it.next();
            System.out.println(atualFunc.getNome() + " - R$"  + atualFunc.pagarFuncionario());
        }
    }
}
