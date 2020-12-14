package Interface;

import Entidades.Contrato;
import Entidades.Departamento;
import Entidades.Enumeracao.NivelTrabalhador;
import Entidades.Trabalhador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class TerminalMenu {
    public static Trabalhador menuTrab() throws ParseException
    {
        // Declaração de variáveis e instanciação de objetos...
        SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        String nome;
        String departamento;
        NivelTrabalhador nivel;
        Double salarioBase;
        // Inputs...
        Scanner scan = new Scanner(System.in);
        System.out.print("Entre com o nome do departamento: ");
        departamento = scan.nextLine();
        System.out.println("- Entre com os dados do trabalhador - ");
        System.out.print("Nome: ");
        nome = scan.nextLine();
        System.out.print("Nível: ");
        nivel = NivelTrabalhador.valueOf(scan.nextLine());
        System.out.print("Salário Base: ");
        salarioBase = scan.nextDouble();
        
        Trabalhador trabalhador = new Trabalhador(nome, new Departamento(departamento), nivel, salarioBase);
        
        System.out.print("Quantos contratos ele trabalhou? ");
        int qtdContratos = scan.nextInt();
        
        for(int i = 0; i < qtdContratos; i++)   
        {
            
            System.out.println("- Entre com os dados do contrato " + (i+1) + " -");
            System.out.print("Valor por hora: ");
            Double valorHora = scan.nextDouble();
            System.out.print("Quantidade de horas: ");
            Integer horas = scan.nextInt();
            clearBuffer(scan);
            System.out.print("Data(dd/MM/yyyy): ");
            data = formatarData.parse(scan.nextLine());
            trabalhador.addContrato(new Contrato(data, valorHora, horas));
        }
        formatarData.applyPattern("MM/yyyy");
        System.out.print("Informe o mês e ano que deseja calcular os ganhos de " + trabalhador.getNome() + " (MM/YYYY): ");
        data = formatarData.parse(scan.nextLine());
        System.out.println(data);
        double ganho = trabalhador.ganhoDoMes(data) + trabalhador.getSalarioBase();
        
        // Output...
        System.out.println(trabalhador.toString());
        System.out.println("Ganho do mês " + data.getMonth() + ": " + ganho);
        scan.close();
        return trabalhador;
    }
    public static void clearBuffer(Scanner scan)
    {
        if (scan.hasNextLine()) {
            scan.nextLine();
        }
    }
}
