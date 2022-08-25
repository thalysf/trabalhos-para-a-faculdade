package composicao;

import java.util.Scanner;

public class Composicao {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        // Instancioando Cálculos...
        
        CalculoValor calculoDiaria = new CalculoDiaria();
        CalculoValor calculoMes = new CalculoMes();
        CalculoValor calculoHora = new CalculoHora();
        
        // Instancia da Conta Estacionamento
        
        ContaEstacionamento conta = new ContaEstacionamento("Carro", 11);
        
        // Realizando os cálculos e mudando comportamento do calcúlo conforme necessidade 
        // Basta trocar a classe que a compõe
        // 
        conta.printaConta();
    }
    
}
