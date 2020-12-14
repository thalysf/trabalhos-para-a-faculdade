package Aplicacao;

import Entidades.Conta_Bancaria;
import Excecoes.Saque_Exception;


public class Programa {

    public static void main(String[] args) {
        Conta_Bancaria conta01 = new Conta_Bancaria(2213, "Thalys", 0.0, 1000.0);
        try
        {
            conta01.deposito(250.0);
            conta01.saque(50.00);
            conta01.saque(200.01);
        }
        catch(Saque_Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(conta01.toString());
    }
    
}
